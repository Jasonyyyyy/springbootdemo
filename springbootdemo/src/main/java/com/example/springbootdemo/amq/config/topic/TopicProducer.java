package com.example.springbootdemo.amq.config.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

/**
 * 发布者
 * @author qzz
 */
@Service
public class TopicProducer {

    @Autowired
    private Topic topic;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送消息
     * @param msg
     */
    public void sendTopic(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}


