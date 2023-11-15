package com.arnovandijck.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Arno Vandijck");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2("Arno", "Vandijck");
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getPersonV1RequestParam() {
        return new PersonV1("Arno Vandijck");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonV2RequestParam() {
        return new PersonV2("Arno", "Vandijck");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1RequestHeaders() {
        return new PersonV1("Arno Vandijck");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2RequestHeaders() {
        return new PersonV2("Arno", "Vandijck");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1AcceptHeaders() {
        return new PersonV1("Arno Vandijck");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2AcceptHeaders() {
        return new PersonV2("Arno", "Vandijck");
    }

}
