package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.MessagingException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() throws MessagingException {
        //Given
        Mail mail = new Mail("test@test.com",  "Tasks: New Trello card", "<h1>Test Message</h>");
//        Mail mail = new Mail("test@test.com", "testCc@test.com", "Test", "Test Message");

        /*SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
//        mailMessage.setCc(mail.getToCc());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());*/
        //When
        simpleEmailService.send(mail);
        //Then
        verify(javaMailSender, times(1)).send(any(MimeMessagePreparator.class));
    }
}