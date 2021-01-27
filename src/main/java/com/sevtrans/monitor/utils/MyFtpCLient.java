package com.sevtrans.monitor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;

public class MyFtpCLient {

    private String server;
    private int port;
    private String user;
    private String password;
    FTPClient ftp;

    public MyFtpCLient(String server, int port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public void open() throws Exception {
        ftp = new FTPClient();
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
            throw new Exception("Login Error");// TODO make customt exception
        }
    }

    public void close() throws IOException {
        ftp.disconnect();
    }

    public FTPFile[] listFiles(String path) throws IOException {
        FTPFile[] files = ftp.listFiles(path, filter);
        return files;
    }

    FTPFileFilter filter = new FTPFileFilter() {

        @Override
        public boolean accept(FTPFile ftpFile) {
            return (ftpFile.isFile() && ftpFile.getName().endsWith(".xml"));
        }
    };

    public void putFileToPath(File file, String path) throws IOException {
        ftp.storeFile(path, new FileInputStream(file));
    }

    public void downloadFile(String source, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        ftp.retrieveFile(source, out);
        out.close();
    }

    public String get(String fileName) throws IOException {
        InputStream remoteInput = ftp.retrieveFileStream(fileName);
        String result = new BufferedReader(new InputStreamReader(remoteInput)).lines()
                .collect(Collectors.joining("\n"));
        remoteInput.close();
        return result;
    }
}