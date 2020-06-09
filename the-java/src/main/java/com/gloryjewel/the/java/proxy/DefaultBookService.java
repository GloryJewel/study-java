package com.gloryjewel.the.java.proxy;

public class DefaultBookService implements BookService {

    @Override
    public Book rent(String name) {
        System.out.println(name + " " + "빌렸다.");
        return new Book();
    }
}
