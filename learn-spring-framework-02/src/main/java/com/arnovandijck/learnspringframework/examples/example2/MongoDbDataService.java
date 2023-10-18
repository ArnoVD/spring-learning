package com.arnovandijck.learnspringframework.examples.example2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // @Repository is a specialization of @Component
@Qualifier("mongo")
public class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveAllData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}
