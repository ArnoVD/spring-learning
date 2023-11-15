package com.arnovandijck.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
//@JsonIgnoreProperties(value = {"field1", "field2"})
@JsonFilter("SomeBeanFilter") // Dynamic filtering
public class SomeBean {
    //    @JsonIgnore     // Static filtering
    private final String field1;
    private final String field2;
    private final String field3;

}
