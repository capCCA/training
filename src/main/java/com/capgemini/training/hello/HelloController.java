package com.capgemini.training.hello;

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

    /**
     * Método para probar el servicio
     * 
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public String prueba() {
        System.out.println("Entro al controlador Get");

        return "Hola Controller";
    }

}