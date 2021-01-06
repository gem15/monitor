package com.sevtrans.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.stream.Collectors;

import com.sevtrans.monitor.service.MyRunner;

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

		InputStream remoteInput = ftp.retrieveFileStream(listFile[0].getName());
		// working
		// BufferedReader br = new BufferedReader(new InputStreamReader(remoteInput));
		// String line = null;
		// while((line = br.readLine()) != null) {
		// System.out.println(line);
		// }

		String result = new BufferedReader(new
		InputStreamReader(remoteInput)).lines().collect(Collectors.joining("\n"));

		remoteInput.close();

		// call completePendingCommand and check its return value to verify success. If
		// this is not done, subsequent commands may behave unexpectedly
		if (!ftp.completePendingCommand()) {
			throw new Exception("Completing Pending Commands Not Successfull");
		}

		// преобразование
		MyRunner myRunner = new MyRunner();
		String output = myRunner.transformer(result.toString());

		System.out.println("stop");
		ftp.logout();
		ftp.disconnect();

	}

}
