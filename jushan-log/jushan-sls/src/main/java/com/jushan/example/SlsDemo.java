package com.jushan.example;

import com.alibaba.fastjson.JSONObject;
import com.jushan.aop.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 山居
 * @CreateTime: 2025-01-09
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@RestController
public class SlsDemo
{
    @RequestMapping("/log")
    @Log(value = "记录不同级别的日志消息")
    public String logExampleDemo(@RequestBody JSONObject jsonObject) {
        // 记录不同级别的日志消息

        log.info("方法内參數 {}",jsonObject.toJSONString());
        return "ok";
    }
}
