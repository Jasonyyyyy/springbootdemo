package com.example.springbootdemo.amq.config.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * 生产者
 * @author asus
 */
@Component
public class Producer {
    @Autowired
    private Queue queue;

    //报错：Could not autowire. No beans of 'JmsMessagingTemplate' type found.
    //原因：使用的spring版本是5.0.4.RELEASE，activemq-all版本5.11.2。这个版本的Spring需要使用JMS 2.0版本，但spring-jms的依赖没有自动导入JMS 2.0，而activemq-core会导入JMS 1.1的依赖，这就导致出现版本问题，
    /**
     * 添加以下依赖解决
     * <dependency>
     *     <groupId>javax.jms</groupId>
     *     <artifactId>javax.jms-api</artifactId>
     *     <version>2.0.1</version>
     * </dependency>
     */
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送消息
     * @param msg
     */
    public void sendMessage(String msg){
        //方法一：添加消息对消息队列
        jmsMessagingTemplate.convertAndSend(queue,msg);
        //方法二：这种方式不需要手动创建queue,系统会自动创建名为test的队列
//        jmsMessagingTemplate.convertAndSend("test",msg);
    }

    /**
     * 发送消息
     * @param msg
     */
    public void sendMessage(String destination,String msg){
        //方法二：这种方式不需要手动创建queue,系统会自动创建名为test的队列
        if(destination!=null){
            jmsMessagingTemplate.convertAndSend(destination,msg);
        }
    }
}
