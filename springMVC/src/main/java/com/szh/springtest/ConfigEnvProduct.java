package com.szh.springtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Product环境
 */

@Configuration
@Profile("product")
public class ConfigEnvProduct {
    @Bean
    public ITest test(){
        return new TestBar();
    }
}
