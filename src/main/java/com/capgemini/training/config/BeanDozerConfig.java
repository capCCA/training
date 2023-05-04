package com.capgemini.training.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Class as a source of Bean definition
//@ComponentScan(basePackages = "xxx") // ejemplo para usar dependencias externas
public class BeanDozerConfig {

    // the returned bean is managed by Spring context.
    @Bean
    public DozerBeanMapper getDozerBeanMapper() {
        return new DozerBeanMapper();
    }

}