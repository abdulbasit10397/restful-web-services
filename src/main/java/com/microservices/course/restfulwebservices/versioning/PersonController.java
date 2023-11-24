package com.microservices.course.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    //Versioning using URI approach
    @GetMapping("v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Abdul Basit");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Abdul", "Basit"));
    }

    //Versioning using parameters in URI
    @GetMapping(value = "person/param", params = "version=1")
    public PersonV1 getParamV1() {
        return new PersonV1("Abdul Basit");
    }

    @GetMapping(value = "person/param", params = "version=2")
    public PersonV2 getParamV2() {
        return new PersonV2(new Name("Abdul", "Basit"));
    }

    //Versioning using Header Parameters
    @GetMapping(value = "person/header", headers = "version=1")
    public PersonV1 getHeaderV1() {
        return new PersonV1("Abdul Basit");
    }

    @GetMapping(value = "person/header", headers = "version=2")
    public PersonV2 getHeaderV2() {
        return new PersonV2(new Name("Abdul", "Basit"));
    }

    //Versioning using Produces
    @GetMapping(value = "person/produces", produces = "application/app-v1+json")
    public PersonV1 getProducesV1() {
        return new PersonV1("Abdul Basit");
    }

    @GetMapping(value = "person/produces", produces = "application/app-v2+json")
    public PersonV2 getProducesV2() {
        return new PersonV2(new Name("Abdul", "Basit"));
    }
}
