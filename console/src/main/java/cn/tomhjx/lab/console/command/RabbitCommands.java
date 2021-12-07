package cn.tomhjx.lab.console.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import cn.tomhjx.lab.core.service.RabbitService;

@ShellComponent
public class RabbitCommands {

    @Autowired
    private RabbitService rabbitService;
    
    @ShellMethod("Publish message")
    public String publish() {
        rabbitService.publish();
        return "ok";
    }

    @ShellMethod("Pull")
    public void pull() {
        rabbitService.pull();
    }

    @ShellMethod("Declare")
    public void declare() {
        rabbitService.declare();
    }
}
