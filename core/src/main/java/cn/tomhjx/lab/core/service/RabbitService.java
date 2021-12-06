package cn.tomhjx.lab.core.service;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitService {

    private static final String QUORUM_A_QUEUE = "app.quorum.a";
    private static final String A_EXCHANGE = "app.a.exchange";
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    // private RabbitAdmin
    private AmqpAdmin rabbitAdmin;

    public void declare() {
        rabbitAdmin.deleteQueue(QUORUM_A_QUEUE);
        
        FanoutExchange fanoutExchange = new FanoutExchange(A_EXCHANGE);
        Queue queue = QueueBuilder.durable(QUORUM_A_QUEUE).quorum().build();

        rabbitAdmin.declareExchange(fanoutExchange);
        rabbitAdmin.declareQueue(queue);

        Binding binding = BindingBuilder.bind(queue).to(fanoutExchange);
        rabbitAdmin.declareBinding(binding);
    } 

    public void publish() {
        rabbitTemplate.convertAndSend(A_EXCHANGE, "", "this is my test.");
        System.out.println("this is rabbit mq publish.");
    }

    public void pull() {
        System.out.println("Received: "+ rabbitTemplate.receiveAndConvert(QUORUM_A_QUEUE));
    }

}
