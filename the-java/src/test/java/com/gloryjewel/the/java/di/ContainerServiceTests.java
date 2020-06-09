package com.gloryjewel.the.java.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTests {

    @Test
    void getObject() {

        HumanRepository humanRepositoryClass = ContainerService.getObject(HumanRepository.class);

        assertNotEquals(humanRepositoryClass, null);
    }

    @Test
    void getObject_humanService(){

        HumanService humanService = ContainerService.getObject(HumanService.class);

        assertNotEquals(humanService, null);
        assertNotEquals(humanService.humanRepository, null);
    }
}