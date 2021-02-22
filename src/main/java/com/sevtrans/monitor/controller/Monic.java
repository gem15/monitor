package com.sevtrans.monitor.controller;

import com.sevtrans.monitor.dto.Shell;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}
