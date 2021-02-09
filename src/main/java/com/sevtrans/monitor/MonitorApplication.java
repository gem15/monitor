package com.sevtrans.monitor;

import com.sevtrans.monitor.service.FtpMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @EnableScheduling
@SpringBootApplication
public class MonitorApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@Autowired
	FtpMsg ftpMsg;
	@Override
	public void run(String... args) throws Exception {
		log.info("command runner");
//		FtpMsg ftpMsg=new FtpMsg();
		// ftpMsg.fileProcessing();

//		ftpMsg.proc();//working
	}


	@Bean
	public FtpMsg ftpMsg(){
		return new FtpMsg();
	}
	/*
	 * public String transformer(String input) throws TransformerException {
	 * TransformerFactory factory = TransformerFactory.newInstance(); Source xslt =
	 * new StreamSource(getClass().getResourceAsStream("/msg.xsl")); Transformer
	 * transformer = factory.newTransformer(xslt);
	 * 
	 * Source source = new StreamSource(new StringReader(input)); // Source source =
	 * new StreamSource(new File("input.xml")); StringWriter output = new
	 * StringWriter(); Result result = new StreamResult(output);
	 * transformer.transform(source, result); // transformer.transform(source, new
	 * StreamResult(new File("output.xml"))); return output.toString();// TODO maybe
	 * return result?
	 * 
	 * }
	 * 
	 * public <T> T unmarshaller(String content, Class<T> clasz) throws
	 * JAXBException { JAXBContext jaxbContext = JAXBContext.newInstance(clasz);
	 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); // TODO
	 * change string to inputstring // Overloaded methods to unmarshal from
	 * different xml sources //
	 * https://howtodoinjava.com/jaxb/jaxb-unmarshaller-example/ return
	 * jaxbUnmarshaller.unmarshal(new StreamSource(content), clasz).getValue(); }
	 * 
	 * public void marshaller(Shell shell) throws JAXBException { JAXBContext
	 * jaxbContext = JAXBContext.newInstance(shell.getClass()); Marshaller
	 * jaxbMarshaller = jaxbContext.createMarshaller(); //
	 * jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // TODO убрать в
	 * релизе jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 * jaxbMarshaller.marshal(shell, new PrintWriter(System.out)); }
	 * 
	 * // TODO set in bindings public XMLGregorianCalendar getNow() throws
	 * DatatypeConfigurationException { GregorianCalendar gregorianCalendar = new
	 * GregorianCalendar(); DatatypeFactory datatypeFactory;
	 * 
	 * datatypeFactory = DatatypeFactory.newInstance(); XMLGregorianCalendar now =
	 * datatypeFactory.newXMLGregorianCalendar(gregorianCalendar); return now; }
	 * 
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
