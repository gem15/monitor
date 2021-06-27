package com.sevtrans.monitor.ftp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

import com.sevtrans.monitor.utils.MyFtpCLient;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_CLASS)
//https://stackoverflow.com/questions/52551718/what-use-is-testinstance-annotation-in-junit-5
public class FtpClientIntegrationTest {//https://www.baeldung.com/java-ftp-client

    private FakeFtpServer fakeFtpServer;

    private MyFtpCLient ftpClient;

    @BeforeAll
    public void setup() throws Exception {
        fakeFtpServer = new FakeFtpServer();
        fakeFtpServer.addUserAccount(new UserAccount("user", "password", "/data"));

        FileSystem fileSystem = new UnixFakeFileSystem();
        fileSystem.add(new DirectoryEntry("/data"));
        // fileSystem.add(new FileEntry("/data/Order.xml", "gem 123"));
        fileSystem.add(new FileEntry("/data/foobar.txt", "abcdef 1234567890"));
        fakeFtpServer.setFileSystem(fileSystem);
        fakeFtpServer.setServerControlPort(0);

        fakeFtpServer.start();

        ftpClient = new MyFtpCLient("localhost", fakeFtpServer.getServerControlPort(), "user", "password");
        // ftpClient = new FtpClient();
        ftpClient.open();
    }

    @AfterAll
    public void teardown() throws IOException {
        ftpClient.close();
        fakeFtpServer.stop();
    }

    // @Test
    // public void givenRemoteFile_whenListingRemoteFiles_thenItIsContainedInList() throws IOException {
    //     Collection<String> files = ftpClient.listFiles("");

    //     assertThat(files).contains("foobar.txt");
    // }

    @Test
    public void givenRemoteFile_whenDownloading_thenItIsOnTheLocalFilesystem() throws IOException {
        ftpClient.downloadFile("/foobar.txt", "downloaded_buz.txt");

        assertThat(new File("downloaded_buz.txt")).exists();
        new File("downloaded_buz.txt").delete(); // cleanup
    }

    @Test
    public void givenLocalFile_whenUploadingIt_thenItExistsOnRemoteLocation() throws URISyntaxException, IOException {
        File file = new File(getClass().getClassLoader().getResource("ftp/baz.txt").toURI());

        ftpClient.putFileToPath(file, "/buz.txt");

        assertThat(fakeFtpServer.getFileSystem().exists("/buz.txt")).isTrue();
    }

}