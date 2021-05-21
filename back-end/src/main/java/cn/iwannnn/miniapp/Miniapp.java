package cn.iwannnn.miniapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("cn.iwannnn.miniapp.mapper")
public class Miniapp {

    public static void main(String[] args) {
        SpringApplication.run(Miniapp.class, args);
    }

}
