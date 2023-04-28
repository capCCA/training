package com.capgemini.training.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    Greeting greeting;

    public String getGreeting() {
        return greeting.getMsg();
    }

    public String getGreeting(String user) {
        if (user != null) {
            return greeting.getMsg() + user.toUpperCase();
        }
        return greeting.getMsg();
    }

}
