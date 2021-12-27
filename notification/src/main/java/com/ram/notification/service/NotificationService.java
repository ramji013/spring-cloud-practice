package com.ram.notification.service;

import com.ram.notification.entity.Notification;
import com.ram.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;


    public boolean sendNotification(String customerId) {
        notificationRepository.save(Notification.builder().customerId(customerId)
                .isNotificationSent("Y").notificationTime(LocalDateTime.now()).build());
        return true;
    }
}
