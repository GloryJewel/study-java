package com.gloryjewel.the.java.annotation;

import com.gloryjewel.the.java.reflection.Book;
import com.gloryjewel.the.java.reflection.MyBook;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyAnnotaionMainTests {


    @Test
    public void createAnnotaion(){

        System.out.println("---------------------------------------------------");
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);
    }

    @Test
    public void getAnnoationFields(){

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if(a instanceof MyAnnotaion){
                    MyAnnotaion myAnnotaion = (MyAnnotaion) a;
                    System.out.println(myAnnotaion.name());
                    System.out.println(myAnnotaion.value());
                }
            });
        });
    }
}