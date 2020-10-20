package org.jyoti.email.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean(name = "javaMailSender")
    public JavaMailSender javaMailSender(@Value("${mail.smtp.host}") String smtpHost,
            @Value("${mail.smtp.port}") int smtpPort,
            @Value("${mail.smtp.username}") String mailName,
            @Value("${mail.smtp.password}") String mailCred,
            @Value("${mail.default-encoding}") String defaultEncoding) {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(smtpHost);
        javaMailSender.setPort(smtpPort);
        javaMailSender.setUsername(mailName);
        javaMailSender.setPassword(mailCred);
        javaMailSender.setDefaultEncoding(defaultEncoding);
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.timeout","5000");
        props.put("mail.smtp.writetimeout","5000");
        props.put("mail.smtp.connectiontimeout","5000");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.debug", "true");
        javaMailSender.setJavaMailProperties(props);
        return javaMailSender;
    }
}
