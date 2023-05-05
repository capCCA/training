package com.capgemini.training.service;

import org.springframework.stereotype.Service;

import com.capgemini.training.entity.Greeting;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GreetingService {
//    @Autowired
//    Greeting greeting;

    private final Greeting greeting;

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
