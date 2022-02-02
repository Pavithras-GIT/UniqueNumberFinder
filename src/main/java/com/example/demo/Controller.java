package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {


   private UniqueNumberService service;
    public Controller(UniqueNumberService service) {
        this.service = service;
    }

    @GetMapping(value = "/generateUniqueNumber")
    public ResponseEntity<Long> getUniqueNumber(@RequestParam(value = "id", required = true) int entries, @RequestBody UniqueNumberRequest request) throws InvalidEntriesException {
        return new ResponseEntity(service.findUniqueNumber(entries,request.getArray(), request.getSum()), HttpStatus.OK);
    }
}
