package cn.tomhjx.lab.core.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cn.tomhjx.lab.core.service.RabbitService;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private RabbitService rabbitService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        rabbitService.declare();
        System.out.println("The Runner start to initialize");
    }
}
