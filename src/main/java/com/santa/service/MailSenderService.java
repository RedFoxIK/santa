package com.santa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Value("${mail.subject}")
    private static String subject;

    @Value("${mail.message}")
    private static String message;

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String mail) {
        System.out.println(message);
        System.out.println(subject);


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
