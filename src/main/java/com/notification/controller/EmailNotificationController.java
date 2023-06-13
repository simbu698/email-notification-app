package com.notification.controller;

import com.notification.model.EmailDetails;
import com.notification.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailNotificationController {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @PostMapping("/api/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details) {
        String status = emailNotificationService.sendSimpleMail(details);
        return status;
    }

    @PostMapping("/api/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details){
        String status = emailNotificationService.sendMailWithAttachment(details);
        return status;
    }

}
