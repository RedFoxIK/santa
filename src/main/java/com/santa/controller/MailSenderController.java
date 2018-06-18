package com.santa.controller;

import com.santa.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailSenderController {

    private static String MAIL = "yaroslavakalashnik@gmail.com";

    @Autowired
    private MailSenderService mailSenderService;

    @PostMapping
    @RequestMapping("/send")
    public void send(Long userId) {
        mailSenderService.sendSimpleMessage(userId);
    }
}
