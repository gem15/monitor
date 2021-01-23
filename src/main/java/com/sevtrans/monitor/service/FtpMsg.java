package com.sevtrans.monitor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sevtrans.monitor.dto.Contractor;
import com.sevtrans.monitor.dto.DeliveryOrder;
import com.sevtrans.monitor.dto.ObjectFactory;
import com.sevtrans.monitor.dto.OrderLineItem;
import com.sevtrans.monitor.dto.Product;
import com.sevtrans.monitor.dto.Shell;
import com.sevtrans.monitor.dto.Vehicle;
import com.sevtrans.monitor.service.MyRunner;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;

// import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FtpMsg {
    // #region ftp vars
    @Value("${ftp.host}")
    private String server;
    @Value("${ftp.port}")
    private int port;
    @Value("${ftp.user}")
    private String user;
    @Value("${ftp.password}")
    private String password;
    // #endregion

    public void fileProcessing() throws Exception{

        log.info("FTP");
        // #region FTP
        FTPClient ftp = new FTPClient();
        ftp.connect(server, port);
        ftp.enterLocalPassiveMode();
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }

        if (!ftp.login(user, password)) {
            ftp.logout();
            throw new Exception("Login Error");
        }

        FTPFileFilter filter = new FTPFileFilter() {

            @Override
            public boolean accept(FTPFile ftpFile) {
                return (ftpFile.isFile() && ftpFile.getName().endsWith(".xml"));
            }
        };
        FTPFile[] listFile = ftp.listFiles("/", filter);
        for (FTPFile aFile : listFile) {
            String currentFileName = aFile.getName();
            System.out.println(currentFileName);
        }
        /*
         * // working BufferedReader br = new BufferedReader(new
         * InputStreamReader(remoteInput)); String line = null; while((line =
         * br.readLine()) != null) { System.out.println(line); }
         */
        InputStream remoteInput = ftp.retrieveFileStream(listFile[0].getName());

        String result = new BufferedReader(new InputStreamReader(remoteInput)).lines()
                .collect(Collectors.joining("\n"));

        remoteInput.close();

        // call completePendingCommand and check its return value to verify success. If
        if (!ftp.completePendingCommand()) {
            throw new Exception("Completing Pending Commands Not Successfull");
        }
        // #endregion

        // xslt преобразование
        String output = transformer(result);

        System.out.println("stop");
        ftp.logout();
        ftp.disconnect();
        log.info("Finish");

        // #region test marshalling
        ObjectFactory factory = new ObjectFactory();
        Shell shell = factory.createShell();
        shell.setCustomer(1);
        shell.setMsgType("УП");
        Product product = new Product();
        product.setArticle("art");
        product.setName("Product Name");
        product.setUpc("UPC");
        shell.setProduct(product);
        marshaller(shell);

        Shell shell1 = new Shell();
        shell1.setCustomer(1);
        shell1.setMsgType("УП");

        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setDeliveryType("dlvrType");

        Vehicle vehicle = new Vehicle();
        vehicle.setDriver("driver");
        vehicle.setLicencePlate("lic");
        deliveryOrder.setOrderNo("order#");
        deliveryOrder.setOrderDate(getNow());
        deliveryOrder.setOrderType("fack");
        deliveryOrder.setPlannedDate(getNow());
        Contractor contractor = new Contractor();
        contractor.setAdress("supAdr");
        contractor.setCode("supCode");
        contractor.setName("supName");

        OrderLineItem od = new OrderLineItem();
        od.setArticle("A1");
        od.setLineNumber(1);
        od.setName("name of");
        od.setQty(new BigDecimal("2.5"));
        deliveryOrder.getLineItem().add(od);
        OrderLineItem od1 = new OrderLineItem();
        od1.setArticle("A1");
        od1.setLineNumber(1);
        deliveryOrder.getLineItem().add(od1);

        shell1.setDeliveryOrder(deliveryOrder);
        marshaller(shell1);
        // #endregion
    }

    public String transformer(String input) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(getClass().getResourceAsStream("/msg.xsl"));
        Transformer transformer = factory.newTransformer(xslt);

        Source source = new StreamSource(new StringReader(input));
        // Source source = new StreamSource(new File("input.xml"));
        StringWriter output = new StringWriter();
        Result result = new StreamResult(output);
        transformer.transform(source, result);
        // transformer.transform(source, new StreamResult(new File("output.xml")));
        return output.toString();// TODO maybe return result?

    }

    public <T> T unmarshaller(String content, Class<T> clasz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clasz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // TODO change string to inputstring
        // Overloaded methods to unmarshal from different xml sources
        // https://howtodoinjava.com/jaxb/jaxb-unmarshaller-example/
        return jaxbUnmarshaller.unmarshal(new StreamSource(content), clasz).getValue();
    }

    public void marshaller(Shell shell) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(shell.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        // TODO убрать в релизе
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(shell, new PrintWriter(System.out));
    }

    // TODO set in bindings
    public XMLGregorianCalendar getNow() throws DatatypeConfigurationException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory;

        datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }

    /*
     * private boolean validate(String xmlFile, String schemaFile) { SchemaFactory
     * schemaFactory =
     * SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); try { Schema
     * schema = schemaFactory.newSchema(new File(getResource(schemaFile)));
     * 
     * Validator validator = schema.newValidator(); validator.validate(new
     * StreamSource(new File(getResource(xmlFile)))); return true; } catch
     * (SAXException | IOException e) { e.printStackTrace(); return false; } }
     */

}
