package com.arnovandijck.learnspringaop.aopexample.data;

import org.springframework.stereotype.Service;

@Service
public class DataService1 {

    public int[] retrieveData() {
        return new int[] {1, 2, 3};
    }
}
