package com.sudeepnm.redis.sortedsets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class App {

    public static void main (String... args){
        SpringApplication.run(App.class, args);
    }


}
