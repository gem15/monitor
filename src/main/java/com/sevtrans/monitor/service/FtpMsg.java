package com.sevtrans.monitor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URL;
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

import com.sevtrans.monitor.MonitorCommonException;
import com.sevtrans.monitor.dto.Contractor;
import com.sevtrans.monitor.dto.DeliveryOrder;
import com.sevtrans.monitor.dto.ObjectFactory;
import com.sevtrans.monitor.dto.OrderLineItem;
import com.sevtrans.monitor.dto.Product;
import com.sevtrans.monitor.dto.Shell;
import com.sevtrans.monitor.dto.Vehicle;
import com.sevtrans.monitor.service.MyRunner;
import com.sevtrans.monitor.utils.MyFtpCLient;

import com.sevtrans.monitor.utils.XmlUtiles;
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

import org.xml.sax.SAXException;

import java.net.SocketException;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Component;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
// import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FtpMsg {
    @Value("${ftp.host}")
    private String server;
    @Value("${ftp.port}")
    private int port;
    @Value("${ftp.user}")
    private String user;
    @Value("${ftp.password}")
    private String password;
    @Value("${schemaFile}")
    private String xmlSchema;

    private XmlUtiles xmlUtiles = new XmlUtiles();

    @Deprecated
    public void fileProcessing() throws SocketException, IOException, TransformerException {

        log.info("FTP");
        FTPClient ftp = new FTPClient();
        ftp.connect(server, port);
        // ftp.connect("localhost", 21);
        ftp.enterLocalPassiveMode();
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }

        if (!ftp.login("anonymous", "")) {
            // if (!ftp.login(user, password)) {
            ftp.logout();
            // throw new Exception("Login Error");
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

        // https://www.baeldung.com/java-try-with-resources
        try (InputStream remoteInput = ftp.retrieveFileStream(listFile[0].getName())) {
            String result = new BufferedReader(new InputStreamReader(remoteInput)).lines()
                    .collect(Collectors.joining("\n"));

            // xslt преобразование
            String output = xmlUtiles.transformer(result);
            log.info(output);
            // remoteInput.close();

        }

        // call completePendingCommand and check its return value to verify success. If
        if (!ftp.completePendingCommand()) {
            // TODO make custom exception
            // !!! throw new Exception("Completing Pending Commands Not Successfull");
        }

        ftp.logout();
        ftp.disconnect();
        log.info("Finish");
        // #endregion

        // #region test marshalling
        /*
         * ObjectFactory factory = new ObjectFactory(); Shell shell =
         * factory.createShell(); shell.setCustomer(1); shell.setMsgType("УП"); Product
         * product = new Product(); product.setArticle("art");
         * product.setName("Product Name"); product.setUpc("UPC");
         * shell.setProduct(product); marshaller(shell);
         *
         * Shell shell1 = new Shell(); shell1.setCustomer(1); shell1.setMsgType("УП");
         *
         * DeliveryOrder deliveryOrder = new DeliveryOrder();
         * deliveryOrder.setDeliveryType("dlvrType");
         *
         * Vehicle vehicle = new Vehicle(); vehicle.setDriver("driver");
         * vehicle.setLicencePlate("lic"); deliveryOrder.setOrderNo("order#");
         * deliveryOrder.setOrderDate(getNow()); deliveryOrder.setOrderType("fack");
         * deliveryOrder.setPlannedDate(getNow()); Contractor contractor = new
         * Contractor(); contractor.setAdress("supAdr"); contractor.setCode("supCode");
         * contractor.setName("supName");
         *
         * OrderLineItem od = new OrderLineItem(); od.setArticle("A1");
         * od.setLineNumber(1); od.setName("name of"); od.setQty(new BigDecimal("2.5"));
         * deliveryOrder.getLineItem().add(od); OrderLineItem od1 = new OrderLineItem();
         * od1.setArticle("A1"); od1.setLineNumber(1);
         * deliveryOrder.getLineItem().add(od1);
         *
         * shell1.setDeliveryOrder(deliveryOrder); marshaller(shell1);
         */
        // #endregion
    }

    public void proc() {
        MyFtpCLient ftp = new MyFtpCLient("localhost", 21, "anonymous", "");
        try {
            ftp.open();
            FTPFile[] files = ftp.listFiles("/");

            for (FTPFile file : files) {
                // #1 get file from ftp
                String source = ftp.get(file.getName());

                // # 2 transform it //TODO xmlns=""
                String output = xmlUtiles.transformer(source);
                 log.info(output);

                // #3 validate
//                if (!xmlUtiles.validate(output.replaceAll("xmlns=\"\"", ""), xmlSchema)) {
                if (!xmlUtiles.validate(output, xmlSchema)) {
                    log.error("Ошибка в файле " + file.getName());
                    continue;
                }

                // #4 unmarshall with validation
                Shell shell = xmlUtiles.unmarshaller(output, Shell.class);//, xmlSchema
                log.info(shell.getMsgType());
            }
//TODO ftp delete source file
            ftp.close();
        } catch (MonitorCommonException me) {
            log.error(me.getMessage());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.info("Something goes wrong///");
            e.printStackTrace();
        }


    }
}
