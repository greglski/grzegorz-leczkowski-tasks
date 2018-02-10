package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.scheduler.EmailScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BuildEmailFactory {
    @Autowired
    private MailCreatorService mailCreatorService;

    public String buildEmail(Mail mail) {
        switch (mail.getSubject()) {
            case EmailScheduler.SUBJECT:
                return mailCreatorService.buildScheduledEmail(mail.getMessage());
            case TrelloService.SUBJECT:
                return mailCreatorService.buildTrelloCardEmail(mail.getMessage());
            default:
                return null;
        }
    }
}
