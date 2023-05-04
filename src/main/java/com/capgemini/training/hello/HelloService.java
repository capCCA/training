package com.capgemini.training.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getHello() {
        return "Hola Mundo";
    }

}
