package com.sevtrans.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sevtrans.monitor.dto.ObjectFactory;
import com.sevtrans.monitor.dto.Product;
import com.sevtrans.monitor.dto.Shell;
import com.sevtrans.monitor.service.MyRunner;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MonitorApplication implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Hello, world from CommandLineRunner");
		System.out.println();
		// #region FTP
		FTPClient ftp = new FTPClient();
		ftp.connect(server, port);
		// FtpClient fc = new FtpClient("127.0.0.1", 21,"anonymous", "nebulus");//
		// "123456"
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
		// working
		// BufferedReader br = new BufferedReader(new InputStreamReader(remoteInput));
		// String line = null;
		// while((line = br.readLine()) != null) {
		// System.out.println(line);
		// }
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

		ObjectFactory factory=new ObjectFactory();
		Shell shell = factory.createShell();
		shell.setCustomer(1);
		shell.setMsgType("УП");
		Product product=new Product();
		product.setCode("Code");
		product.setName("Product Name");
		product.setUpc("UPC");
		shell.setProduct(product);
		marshaller(shell);

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

	public  void marshaller(Shell shell) throws JAXBException {
		JAXBContext jaxbContext     = JAXBContext.newInstance( shell.getClass() );
		Marshaller jaxbMarshaller   = jaxbContext.createMarshaller();
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        // TODO убрать в релизе
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal( shell, new PrintWriter( System.out ) );
	}
}
