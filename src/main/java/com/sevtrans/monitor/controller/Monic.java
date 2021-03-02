package com.sevtrans.monitor.controller;

import com.sevtrans.monitor.dto.Shell;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("/order")
    public ResponseEntity GetMessage(@RequestBody Shell shell) {
        System.out.println(shell.getMsgType());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/report", produces = APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/report/Employee_report.pdf");
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return  buffer.toByteArray();//IOUtils.toByteArray(in);//in.readAllBytes();//
    }
}
