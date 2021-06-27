package com.sevtrans.monitor.controller;

import com.sevtrans.monitor.dto.DeliveryOrder;
import com.sevtrans.monitor.dto.Order;
import com.sevtrans.monitor.service.Report;
import com.sevtrans.monitor.utils.XmlUtiles;
import org.apache.commons.io.IOUtils;
import com.sevtrans.monitor.dto.Shell;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.springframework.http.MediaType.*;

@Slf4j
@CrossOrigin //TODO don't forget about
@RestController
@RequestMapping("/api")
public class Monic {

    @Autowired
    Report report;

    private XmlUtiles xmlUtiles = new XmlUtiles();

    @PostMapping("/order")
    public ResponseEntity GetMessage(@RequestBody Shell shell) {
        System.out.println(shell.getMsgType());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/report1", produces = APPLICATION_PDF_VALUE)
    public byte[] getFile1() throws IOException {
/*

        // #1 get file from ftp
        String source = ftp.get(file.getName());

        // # 2 transform it
        String output = xmlUtiles.transformer(source);
        log.info(output);

        // #3 validate
//                if (!xmlUtiles.validate(output.replaceAll("xmlns=\"\"", ""), xmlSchema)) {
        if (!xmlUtiles.validate(output, xmlSchema)) {
            log.error("Ошибка в файле " + file.getName());
            continue;
        }

        // #4 unmarshall with validation
        Shell shell = xmlUtiles.unmarshaller(output, Shell.class);//, xmlSchema
*/

        return null;
    }


    @GetMapping(value = "/report", produces = APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/reports/Employee_report.pdf");
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();//IOUtils.toByteArray(in);//in.readAllBytes();//
//        return IOUtils.toByteArray(in);//in.readAllBytes();//
    }
}
