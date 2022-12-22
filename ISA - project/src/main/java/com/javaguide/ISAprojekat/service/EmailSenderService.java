package com.javaguide.ISAprojekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(String toEmail,String subject,String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("isa.hospitall@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("mail sent successfully");
    }
    @Async
    public void sendRegistrationEmail(String toEmail,String subject,String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("isa.hospitall@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("mail sent successfully");
    }
}
