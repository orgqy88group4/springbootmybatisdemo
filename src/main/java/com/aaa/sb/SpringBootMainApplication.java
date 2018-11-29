package com.aaa.sb;

/**
 * className:SpringBootMainApplication
 * discription:
 * author:qcm
 * createTime:2018-11-21 10:21
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aaa.sb.dao")  //扫描dao层接口
public class SpringBootMainApplication {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApplication.class);
    }

}
