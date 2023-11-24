package com.microservices.course.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {

    @GetMapping("/static-filtering-way-1")
    public StaticBean getSomeBean(){
        return new StaticBean("value 1", "value 2", "value 3");
    }

    @GetMapping("/static-filtering-way-2")
    public OtherStaticBean getSomeOtherBean(){
        return new OtherStaticBean("other value 1", "other value 2", "other value 3");
    }
}
