package com.sevtrans.monitor.service;

import org.springframework.beans.factory.annotation.Value;

@Deprecated
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
}
