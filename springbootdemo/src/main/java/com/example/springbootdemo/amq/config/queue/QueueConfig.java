package com.example.springbootdemo.amq.config.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;


@Configuration
public class QueueConfig {

    @Value("${spring.activemq.queue.name}")
    private String queueName;

    /**
     *  定义存放消息的队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queueName);
    }
}
