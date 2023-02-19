package com.example.springbootdemo.amq.controller;

import com.example.springbootdemo.amq.config.queue.Producer;
import com.example.springbootdemo.amq.config.topic.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * active mq 测试接口
 * @author asus
 */
@RestController
public class JmsTestController {
    @Autowired
    private Producer producer;

    /**
     * 发送消息
     */
@GetMapping("/sendQueueMessages")
    public void sendQueueMessages(){
        for (int i=0;i<5;i++){
            producer.sendMessage("重大消息，重大消息，猪肉降价了！！！："+i);
        }
    }

    @Autowired
    private TopicProducer topicProducer;

    /**
     * 发送消息
     */
    @GetMapping("/sendTopicMessages")
    public void sendTopicMessages(){
        for (int i=0;i<5;i++){
            topicProducer.sendTopic("好消息，好消息，大米降价了！！！："+i);
        }
    }
}
