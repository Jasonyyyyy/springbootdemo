package com.example.springbootdemo.amq.config.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @author asus
 */
@Component
public class Consumer {

    /**
     * 消费消息
     * 使用JmsListener配置消费者监听的队列，其中message是接收到的消息
     *
     * @SendTo("Squeue"):SendTo会将此方法返回的数据，写入到OutQueue中去
     * @param message
     */
//    @JmsListener(destination = "firstQueue")
    @JmsListener(destination = "${spring.activemq.queue.name}")
    public void receiveQueue(String message){
        System.out.println("Consumer接收的消息是："+message);
    }

    @JmsListener(destination = "${spring.activemq.queue.name}")
    public void receiveQueue2(String message){
        System.out.println("Consumer2接收的消息是："+message);
    }
}
