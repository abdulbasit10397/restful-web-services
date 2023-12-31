package com.microservices.course.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class HelloWorldInternationalizedController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world-international")
    public String HelloWorldInternational(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {

        return messageSource.getMessage("good.morning.message", null, locale);
    }
}
