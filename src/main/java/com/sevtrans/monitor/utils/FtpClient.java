package com.sevtrans.monitor.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FtpClient {

    private String server;
    private int port;
    private String user;
    private String password;
    FTPClient ftp;

    public FtpClient(String server, int port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public void open() throws Exception {
        ftp = new FTPClient();
        // password =
        // System.getProperty("user.name")+"@127.0.0.1";//+InetAddress.getLocalHost().getHostName();
        // TODO ? ftp.addProtocolCommandListener(new PrintCommandListener(new
        // PrintWriter(System.out)));
        ftp.connect(server, port);
        ftp.enterLocalPassiveMode();
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }

        // TODO enhance ftp.login
        if (!ftp.login(user, password)) {
            ftp.logout();
            throw new Exception("Login Error");
        }
    }

    public void close() throws IOException {
        ftp.disconnect();
    }

    public FTPFile[] listFiles(String path) throws IOException {
        // public Collection<String> listFiles(String path) throws IOException {
        FTPFile[] files = ftp.listFiles(path);
        // return Arrays.stream(files).map(FTPFile::getName).collect(Collectors.toList());
        return files;
    }

    public void putFileToPath(File file, String path) throws IOException {
        ftp.storeFile(path, new FileInputStream(file));
    }

    public void downloadFile(String source, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        ftp.retrieveFile(source, out);
        out.close();
    }
}