package com.example.acountdemo.controller;

import com.example.acountdemo.model.Acount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AcountController {
    @GetMapping (path = "/acount")
    public ResponseEntity<List<Acount>> searchAcounts (){
        List<Acount> list = new ArrayList<Acount>();
        Acount acount1 = new Acount("DanielBlaga", "b.d@email.example","password");
        Acount acount2 = new Acount("dev", "dev@dev","dev");

        list.add(acount1);
        list.add(acount2);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping(path = "/acount")
    public ResponseEntity<Acount> createAcount(@RequestBody Acount acount){
        acount.setEmail(acount.getEmail()+".com");
        return new ResponseEntity<>(acount,HttpStatus.CREATED);
    }



}
