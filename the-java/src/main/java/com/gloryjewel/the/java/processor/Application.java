package com.gloryjewel.the.java.processor;

import java.lang.reflect.InvocationTargetException;

public class Application {

    public static void main(String[] arg){

        try {

            Class majaFactory = Class.forName("com.gloryjewel.the.java.processor.MojaFactory");

            Moja moja = (Moja) majaFactory.getConstructor().newInstance();
            System.out.println(moja.pullOut());

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
