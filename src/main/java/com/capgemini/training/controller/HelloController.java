package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.service.HelloService;

@RequestMapping(value = "/hello")
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("")
    public String saludo(@RequestParam("mensaje") String mensaje) {

        String msg = mensaje;
        return helloService.getHello(msg);
    }

}