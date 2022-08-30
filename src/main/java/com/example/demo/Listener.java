package com.example.demo;

import com.example.demo.model.Bar;
import com.example.demo.model.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.example.demo.RabbitConfig.QUEUE_NAME;

@Component
@RabbitListener(queues = QUEUE_NAME)
@Slf4j
public class Listener {

    @RabbitHandler
    public void handleFoo(Foo foo) {
        log.info("Received foo: {}", foo);
    }

    @RabbitHandler
    public void handleBar(Bar bar) {
        log.info("Received bar: {}", bar);
    }
}
