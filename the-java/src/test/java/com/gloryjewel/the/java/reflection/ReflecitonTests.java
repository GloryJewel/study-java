package com.gloryjewel.the.java.reflection;

import com.gloryjewel.the.java.bytecode.TestTest;
import com.gloryjewel.the.java.proxy.BookService;
import com.gloryjewel.the.java.proxy.DefaultBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReflecitonTests {

    @Test
    public void getClassObject() throws ClassNotFoundException, CloneNotSupportedException {

        List classes = new ArrayList();
        Class bookClassA = Book.class;
        classes.add(bookClassA);

        Book book = new Book();
        Class bookClassB = book.getClass();
        classes.add(bookClassB);

        Class bookClassC = Class.forName("com.gloryjewel.the.java.reflection.Book");
        classes.add(bookClassC);

        assertSame(bookClassA,bookClassB);

        assertEquals(bookClassA,bookClassB);
    }

    @Test
    public void acessClassObject(){

        Class bookClass = Book.class;

        Book book = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {

            try {
                f.setAccessible(true);
                System.out.printf("%s $s \n",f,f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });

        System.out.println("------------------------------");

        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        System.out.println("------------------------------");

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f ->{
            int modifiers = f.getModifiers();
            System.out.println(Modifier.isPrivate(modifiers));
        });
    }

    @Test
    public void mockTest(){

        BookService bookService = mock(DefaultBookService.class);

        when(bookService.rent(any())).thenReturn(new com.gloryjewel.the.java.proxy.Book());
    }
}