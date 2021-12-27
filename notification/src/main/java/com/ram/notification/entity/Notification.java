package com.ram.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Notification {
    @Id
    @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence")
    private Integer id;
    private String customerId;
    private String isNotificationSent;
    private LocalDateTime notificationTime;
}
