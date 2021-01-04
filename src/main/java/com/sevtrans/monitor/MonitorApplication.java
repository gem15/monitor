package com.sevtrans.monitor;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		System.out.println("Hello, world from CommandLineRunner+++++++++++++");

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
		FTPFile[] listFile = ftp.listFiles("/", filter);// "/" data
		for (FTPFile aFile : listFile) {
			String currentFileName = aFile.getName();
			System.out.println(currentFileName);
		}
		// fc.downloadFile("source", "destination");
		System.out.println("stop");
		ftp.logout();
		ftp.disconnect();

	}

}
