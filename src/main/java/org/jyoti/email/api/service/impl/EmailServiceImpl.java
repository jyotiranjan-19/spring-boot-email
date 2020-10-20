package org.jyoti.email.api.service.impl;

import org.jyoti.email.api.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String FROM = "no-reply@usage.zimbra.com";
    private static final String EMAIL_TEMPLATE = "Hi %s, Your Password has been reset. Your new login password is: <b>%s</b>\n";

    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String[] to, String subject, String user, String newPassword) throws MessagingException, IOException {
        String body = String.format(EMAIL_TEMPLATE, user, newPassword);

        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        mailMessage.setSubject(subject, "UTF-8");

        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");
        helper.setFrom("jyotiranjan.jena@synacor.com");
        helper.setTo(to);
        helper.setText(body, true);
        javaMailSender.send(helper.getMimeMessage());
    }

    @Override
    public void sendEmailWithAttachment(String[] to, String subject, String user, String newPassword, File attahment) throws MessagingException, IOException {

    }
}
