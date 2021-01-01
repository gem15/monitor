package com.sevtrans.monitor.service;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, world from CommandLineRunner+++++++++++++");
        FtpClient  sd;

    }
//https://stackoverflow.com/a/6438729/2289282
    public String transformer() throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("transform.xslt"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File("input.xml"));
        transformer.transform(text, new StreamResult(new File("output.xml")));
        return null;

    }

   /**
    * 
    * @param sSourcee
    * @param sXsltt
    * @return
    * @throws TransformerException
    */
    public static String Transform(String sSourcee, InputStream sXsltt) throws TransformerException // ,TransformerConfigurationException
    {
        Source xslt = new StreamSource(sXsltt);// new StringReader(sXsltt)
        Source source = new StreamSource(new StringReader(sSourcee));
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);

        TransformerFactory transFactory = TransformerFactory.newInstance();
        transFactory.setAttribute("indent-number", 2);
        Transformer transf = transFactory.newTransformer(xslt);
        // https://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        transf.transform(source, result);

        return sw.toString();
    }

}
