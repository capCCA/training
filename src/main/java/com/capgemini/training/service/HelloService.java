package com.capgemini.training.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getHello(String mensaje) {

        if (mensaje.isEmpty())
            mensaje = "Debe introducir un parametro mensaje en la url";

        return mensaje;
    }

}
