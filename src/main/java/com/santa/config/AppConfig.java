package com.santa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.santa.repository")
public class AppConfig {
    private static final String TRANSPORT_PROTOCOL_KEY = "mail.transport.protocol";
    private static final String TRANSPORT_PROTOCOL_VALUE = "smtp";
    private static final String AUTH_KEY = "mail.smtp.auth";
    private static final String STARTTLS_KEY = "mail.smtp.starttls.enable";
    private static final String DEBUG_KEY = "mail.debug";
    private static final String TRUE_VALUE = "true";


    @Value("${mail.host}")
    private String mailHost;

    @Value("${mail.port}")
    private Integer mailPort;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put(TRANSPORT_PROTOCOL_KEY, TRANSPORT_PROTOCOL_VALUE);
        props.put(AUTH_KEY, TRUE_VALUE);
        props.put(STARTTLS_KEY, TRUE_VALUE);
        props.put(DEBUG_KEY, TRUE_VALUE);

        return mailSender;
    }
}
