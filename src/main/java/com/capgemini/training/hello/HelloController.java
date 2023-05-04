package com.capgemini.training.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ezm
 * 
 */

@RequestMapping(value = "/hello")
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    /**
     * Método para probar el servicio
     * 
     */
    @RequestMapping(path = "", method = RequestMethod.GET)

    public String saludo() {

        return helloService.getHello();
    }

}