package cn.tomhjx.lab.console.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import cn.tomhjx.lab.core.entity.MysqlSampleDO;
import cn.tomhjx.lab.core.service.MysqlSampleService;

@ShellComponent
public class MysqlSampleCommands {

    @Autowired
    private MysqlSampleService mysqlSampleService;

    @ShellMethod("mysql的常见使用场景")
    public String mysqlSampleGeneralCase() {
        MysqlSampleDO sampleDO = mysqlSampleService.createRecordWithTransaction();
        mysqlSampleService.general(sampleDO);
        return "done";
    }
    
}
