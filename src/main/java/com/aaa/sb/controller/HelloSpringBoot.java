package com.aaa.sb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className:HelloSpringBoot
 * discription:
 * author:qcm
 * createTime:2018-11-21 10:23
 */
@RestController  //默认返回值都是json
public class HelloSpringBoot {
    @RequestMapping("/hello")
    public Object print () {
        return "heiio------------";
    }
}
