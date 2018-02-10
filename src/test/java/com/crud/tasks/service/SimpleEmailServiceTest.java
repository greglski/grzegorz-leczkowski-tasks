package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private BuildEmailFactory buildEmailFactory;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com",  "Tasks: New Trello card", "Test Message");
//        Mail mail = new Mail("test@test.com", "testCc@test.com", "Test", "Test Message");

        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setTo(mail.getMailTo());
                messageHelper.setSubject(mail.getSubject());
                messageHelper.setText(mail.getMessage(), true);
            }
        };

        when(buildEmailFactory.buildEmail(mail)).thenReturn("Test Message");

        /*SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
//        mailMessage.setCc(mail.getToCc());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());*/
        //When
        simpleEmailService.send(mail);
        //Then
        verify(javaMailSender, times(1)).send(mimeMessagePreparator);
    }
}