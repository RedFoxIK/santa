package com.santa.controller;

import com.santa.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailSenderController {

    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping
    @RequestMapping("/send")
    public void send() {
        mailSenderService.sendSimpleMessage();
    }
}
