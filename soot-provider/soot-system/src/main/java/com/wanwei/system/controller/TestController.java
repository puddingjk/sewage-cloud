package com.wanwei.system.controller;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class TestController {

    @Value("${config.name}")
    private String configName;

    @Value("${pc.version}")
    private String version;

    @GetMapping("/t")
    public String test(){
        String result = "soot-base:成功";
        log.error(result);
        return result+" 配置" +configName;
    }
    @GetMapping("/t1")
    @GlobalTransactional(name = "test-事物",rollbackFor = Exception.class)
    public String test1(){
        return version;
    }
}
