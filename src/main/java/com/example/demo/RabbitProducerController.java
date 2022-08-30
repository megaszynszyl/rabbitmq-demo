package com.example.demo;

import com.example.demo.model.Bar;
import com.example.demo.model.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class RabbitProducerController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/foo")
    public void produceFoo(@RequestBody Foo foo) {
        log.info("Sending foo: {}", foo);
        rabbitTemplate.convertAndSend(foo);
    }


    @PostMapping("/bar")
    public void produceBar(@RequestBody Bar bar) {
        log.info("Sending bar: {}", bar);
        rabbitTemplate.convertAndSend(bar);
    }
}
