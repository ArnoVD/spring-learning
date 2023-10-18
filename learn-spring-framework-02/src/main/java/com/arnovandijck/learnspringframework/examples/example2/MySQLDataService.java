package com.arnovandijck.learnspringframework.examples.example2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // @Repository is a specialization of @Component
@Primary
public class MySQLDataService implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
