package com.javaguide.ISAprojekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

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
    @Async
    public void sendQREmail(String toEmail,String subject) throws MessagingException {
        //SimpleMailMessage message=new SimpleMailMessage();
        //message.setFrom("isa.hospitall@gmail.com");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("isa.hospitall@gmail.com");
        helper.setTo(toEmail);
        helper.setSubject(subject);

        File attachment = new File("./src/main/resources/QRCode.png");
        // attach the file into email body
        FileSystemResource file = new FileSystemResource(attachment);
        helper.addInline(attachment.getName(), file);

        mailSender.send(mimeMessage);

        System.out.println("Email sending complete.");
    }
}
