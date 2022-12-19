package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.models.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sendMail")
public class EmailServiceController {

    @Autowired
    private EmailService emailDao;

    @PostMapping("/send")
    public boolean poslji(@RequestBody Map<String, Object> podatki){
        System.out.println(podatki);
        return emailDao.sendSimpleMail(podatki.get("recipient").toString(), podatki.get("subject").toString(), podatki.get("body").toString());
    }
}
