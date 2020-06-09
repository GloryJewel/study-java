package com.gloryjewel.the.java.bytecode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;

class TestTestTests {

    @Mock
    PrintStream out;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test1() {

        TestTest testTest = new TestTest(out);

        testTest.test("밥");

        verify(out).println("2222");

        testTest.test("11");

        verify(out).println("1111");

        assertNotEquals(out, null);
    }
}