package com.example.springbootdemo.amq.config.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 订阅者
 * @author qzz
 */

@Component
public class TopicConsumer {

    /**
     * 消费消息
     * 使用JmsListener配置消费者监听的topic，其中message是接收到的消息
     * @param message
     */
    //注意：JmsListener注解默认只接收queue消息,如果要接收topic消息,需要设置containerFactory
    @JmsListener(destination = "${spring.activemq.topic.name}",containerFactory = "topicListener")
    public void receiveTopic(String message){
        System.out.println("TopicConsumer接收的消息是："+message);
    }

    @JmsListener(destination = "${spring.activemq.topic.name}",containerFactory = "topicListener")
    public void receiveTopic2(String message){
        System.out.println("TopicConsumer2接收的消息是："+message);
    }
}

