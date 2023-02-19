package com.example.springbootdemo.amq.config.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Topic;

/**
 * Topic配置
 *  Topic:发布/订阅模式，生产者生产了一个消息，可以由多个消费者进行消费
 * @author qzz
 */
@Configuration
public class TopicConfig {

    @Value("${spring.activemq.topic.name}")
    private String topic;

    /**
     * 定义存放消息的topic
     * @return
     */
    @Bean
    public Topic topic() {
        return new ActiveMQTopic(topic);
    }

}

