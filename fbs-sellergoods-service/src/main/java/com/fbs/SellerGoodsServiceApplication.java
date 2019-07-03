package com.fbs;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDubbo  //开启基于注解的dubbo功能
@MapperScan(value = "com.fbs.mapper")
public class SellerGoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerGoodsServiceApplication.class, args);
    }
}
