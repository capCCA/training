package com.capgemini.training.config;

import org.springframework.context.annotation.Configuration;

//No se usa
@Configuration // Class as a source of Bean definition
//@ComponentScan(basePackages = "org.dozer") // ejemplo para usar dependencias externas
public class BeanDozerConfig {

    // the returned bean is managed by Spring context.
 /*
    @Bean
    public DozerBeanMapper getDozerBeanMapper() {

        return new DozerBeanMapper();
    }

  */

}