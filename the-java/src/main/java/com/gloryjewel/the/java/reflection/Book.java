package com.gloryjewel.the.java.reflection;

import com.gloryjewel.the.java.annotation.MyAnnotaion;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

@MyAnnotaion("^^")
public class Book{

    private String a = "a";

    private static String B = "Book";

    private static final String C ="BOOK";

    public String d = "d";

    protected String e = "e";

    public Book(){

    }

    public Book(String a, String d, String e){
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f(){
        System.out.println("F");
    }

    public void g(){
        System.out.println("g");
    }

    public int h(){
        return 100;
    }


}
