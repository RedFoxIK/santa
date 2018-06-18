package com.santa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    private static String MESSAGE = "Hi. It send from controller";
    private static String SUBJECT = "Controller topic";
    private static String EMAIL = "yaroslavakalashnik@gmail.com";

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(EMAIL);
        message.setSubject(SUBJECT);
        message.setText(MESSAGE);
        mailSender.send(message);
        System.out.print("SUCCESS");

    }
}
