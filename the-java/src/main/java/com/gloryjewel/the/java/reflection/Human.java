package com.gloryjewel.the.java.reflection;

public class Human {

    public static String A = "A";

    private String B = "B";

    public String name;

    public Human(){

    }

    public Human(String name){
        this.name = name;
    }

    public void c(){
        System.out.println("c");
    }

    public int sum(int left, int right){
        return left + right;
    }
}
