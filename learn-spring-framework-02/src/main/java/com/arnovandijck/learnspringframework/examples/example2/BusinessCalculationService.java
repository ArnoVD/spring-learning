package com.arnovandijck.learnspringframework.examples.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service // @Service is a specialization of @Component
public class BusinessCalculationService {
    private final DataService dataService;

    @Autowired
    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveAllData()).max().orElse(Integer.MIN_VALUE);
    }
}
