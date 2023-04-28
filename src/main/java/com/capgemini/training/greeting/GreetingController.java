package com.capgemini.training.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class GreetingController {
    @Autowired
    GreetingService dummyservice;

    /**
     * Method that returns a basic greeting
     * 
     * @return {@link Greeting}
     */
    @GetMapping(path = "")
    public String getGreeting() {
        return dummyservice.getGreeting();
    }

    // Not needed
    /**
     * Method that returns a greeting if the user is given
     * 
     * @param user
     * @return {@link Greeting}
     */

    @GetMapping("/{user}")
    public String getGreeting(@PathVariable(name = "user") String user) {
        return dummyservice.getGreeting(user);
    }

}
