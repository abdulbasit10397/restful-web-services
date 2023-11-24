package com.microservices.course.restfulwebservices.jpa.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JPAUserNotFoundException extends RuntimeException {
    public JPAUserNotFoundException(String s) {
        super(s);
    }
}
