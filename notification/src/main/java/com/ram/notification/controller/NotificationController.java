package com.ram.notification.controller;

import com.ram.clients.notification.NotificationResponse;
import com.ram.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(path = "{customerId}")
    public NotificationResponse sendNotification(String customerId){
        boolean isNotificationSent = notificationService.sendNotification(customerId);
        return new NotificationResponse(isNotificationSent);
    }
}
