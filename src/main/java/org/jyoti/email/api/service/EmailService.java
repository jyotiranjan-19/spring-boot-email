package org.jyoti.email.api.service;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

public interface EmailService {
    public void sendEmail(String[] to, String subject, String user, String newPassword) throws MessagingException, IOException;
    public void sendEmailWithAttachment(String[] to, String subject, String user, String newPassword, File attachment) throws MessagingException, IOException;
}
