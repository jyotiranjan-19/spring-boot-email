package org.jyoti.email.api;

import org.jyoti.email.api.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class SpringBootEmailApplication implements CommandLineRunner {

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmailApplication.class, args);
    }

    @Override public void run(String... args) throws Exception {
        System.out.println("Sending email...");
        try {
            System.out.print(bCryptPasswordEncoder.encode("test@123Zimbra"));
            String[] toAddress = new String[] {"jrjr89@live.com", "jyotiranjanj8@gmail.com"};
            emailService.sendEmail(toAddress,"Testing mail2", "Jyoti","asdfghjioerwf372");
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
