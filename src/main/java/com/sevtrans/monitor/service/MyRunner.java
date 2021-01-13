package com.sevtrans.monitor.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sevtrans.monitor.utils.FtpClient;

//@Component
public class MyRunner {// implements CommandLineRunner {
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

    //#region CommandLineRunner
    // @Override
    // public void run(String... args) throws Exception {
    // System.out.println("Hello, world from CommandLineRunner+++++++++++++");
    // FtpClient fc = new FtpClient(server, port,user, password);
    // // FtpClient fc = new FtpClient("127.0.0.1", 21,"anonymous", "nebulus");//
    // "123456"
    // fc.open();
    // Collection<String> listFile = fc.listFiles("");//"/" data
    // System.out.println(listFile.size());
    // fc.downloadFile("source", "destination");
    // }
    //#endregion

    /**
     * Трансформер
     *  https://stackoverflow.com/a/6438729/2289282
     * @param input
     * @return
     * @throws TransformerException
     */

    /**
     * 
     * @param sSourcee
     * @param sXsltt
     * @return
     * @throws TransformerException
     */
    @Deprecated
    public static String Transform(String sSourcee, InputStream sXsltt) throws TransformerException // ,TransformerConfigurationException
    {
        Source xslt = new StreamSource(sXsltt);// new StringReader(sXsltt)
        Source source = new StreamSource(new StringReader(sSourcee));
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transf = transFactory.newTransformer(xslt);
        // https://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java
        transFactory.setAttribute("indent-number", 2);
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        transf.transform(source, result);

        return sw.toString();
    }

}
