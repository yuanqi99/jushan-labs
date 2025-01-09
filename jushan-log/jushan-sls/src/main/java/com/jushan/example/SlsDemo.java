package com.jushan.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public void logExampleDemo() {
        // 记录不同级别的日志消息

        log.info("{\n" +
                "  \"id\": 0,\n" +
                "  \"operate\": \"\",\n" +
                "  \"code\": \"\",\n" +
                "  \"liveness\": 0,\n" +
                "  \"dailyCount\": 0,\n" +
                "  \"orders\": 0,\n" +
                "  \"isDelete\": \"\",\n" +
                "  \"createBy\": \"\",\n" +
                "  \"createTime\": \"\",\n" +
                "  \"updateBy\": \"\",\n" +
                "  \"updateTime\": \"\",\n" +
                "  \"deleteBy\": \"\",\n" +
                "  \"deleteTime\": \"\"\n" +
                "}");

    }
}
