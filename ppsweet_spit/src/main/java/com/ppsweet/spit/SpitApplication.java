package com.ppsweet.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class SpitApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpitApplication.class,args);
    }

    @Bean
    public IdWorker IdWorker()
    {
        return new IdWorker(1,1);
    }
}
