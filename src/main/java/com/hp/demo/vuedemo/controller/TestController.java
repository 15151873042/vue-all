package com.hp.demo.vuedemo.controller;

import com.hp.demo.vuedemo.dto.TestDTO;
import com.hp.demo.vuedemo.vo.Enums.SysCode;
import com.hp.demo.vuedemo.vo.JsonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public JsonResult test(HttpServletRequest request) {
        return new JsonResult();
    }

    @RequestMapping("/error")
    public JsonResult error() {
        return new JsonResult(SysCode.GET_ERROR);
    }

    // 接口在指定时间后响应数据
    @RequestMapping("/timeout/{sleepTime}")
    public JsonResult timeout(@PathVariable("sleepTime") Long sleepTime) throws InterruptedException {
        Thread.sleep(sleepTime);
        return new JsonResult();
    }

    // 测试application/x-www-form-urlencoded传参
    @RequestMapping("/data/form") public JsonResult dataForm(TestDTO dto) {
        return new JsonResult(dto);
    }

    // 测试application/json传参
    @RequestMapping("/data/json")
    public JsonResult dataJson(@RequestBody TestDTO dto) {
        return new JsonResult(dto);
    }
}
