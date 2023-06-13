package com.notification.service;

import com.notification.model.EmailDetails;

public interface EmailNotificationService {

    public String sendSimpleMail(EmailDetails details);

    public String sendMailWithAttachment(EmailDetails details);
}
