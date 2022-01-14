package cn.tomhjx.lab.console.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import cn.tomhjx.lab.core.service.RedisSampleService;

@ShellComponent
public class RedisSampleCommands {
    
    @Autowired
    private RedisSampleService redisSampleService;

    @ShellMethod("redis的常见使用场景")
    public String redisSampleGeneralCase() {
        redisSampleService.general();
        return "done";
    }
}
