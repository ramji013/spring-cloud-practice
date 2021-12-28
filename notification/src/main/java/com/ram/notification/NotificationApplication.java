package com.ram.notification;


import com.ram.amqp.RabbitMQMessageProducer;
import com.ram.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
        "com.ram.notification",
        "com.ram.amqp"}
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    /*@Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer,
            NotificationConfig notificationConfig
    ){
        return args -> {
            producer.publish(new Person("Ram", 27), notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKeys());
        };
    }

    record Person(String name, int age){
    }*/
}
