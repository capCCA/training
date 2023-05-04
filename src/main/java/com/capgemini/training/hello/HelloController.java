package com.capgemini.training.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 
     */
    @RequestMapping(path = "", method = RequestMethod.GET)

    public String saludo(@RequestParam("mensaje") String mensaje) {

        // URL de entrada, debe recibir como parametro
        // mensaje: http://localhost:8080/hello?mensaje=HolaMundo

        String msg = mensaje;
        return helloService.getHello(msg);
    }

}