package com.fatihmayuk.sr.listener;

import com.fatihmayuk.sr.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "fatih-mayuk-queue")
    public void handleMessage(Notification notification){

        System.out.println("Message received");
        System.out.println(notification.toString());
    
    }
}
