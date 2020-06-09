package com.gloryjewel.the.java.bytecode;

import java.io.PrintStream;

public class TestTest {

    private PrintStream printStream = System.out;

    public TestTest(PrintStream printStream){

        if(printStream != null){
            this.printStream = printStream;
        }
    }

    public void test(String isNull){

        if("밥".equals(isNull)){

            printStream.println("2222");
        }else{

            printStream.println("1111");
        }

    }

    public String say(){

        return "";
    }
}
