package com.gloryjewel.the.java.proxy;

public class BookServiceProxy implements BookService{

    private BookService bookService;

    BookServiceProxy(BookService bookService){
        this.bookService = bookService;
    }

    @Override
    public Book rent(String name) {
        return bookService.rent(name);
    }
}
