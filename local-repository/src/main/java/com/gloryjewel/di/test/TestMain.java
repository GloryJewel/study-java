package com.gloryjewel.di.test;

import com.gloryjewel.the.java.di.ContainerService;

public class TestMain {
    public static void main(String[] args){

        TestService testService = ContainerService.getObject(TestService.class);

        testService.testRepository.print();
    }
}
