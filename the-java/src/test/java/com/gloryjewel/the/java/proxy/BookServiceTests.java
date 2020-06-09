package com.gloryjewel.the.java.proxy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTests {



    @Test
    public void javaProxyTest(){
        //제약사항 반드시 인터페이스 class를 넘겨 줘야
        BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader()
                , new Class[]{BookService.class}, new InvocationHandler() {

                    BookService bookService = new DefaultBookService();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if(method.getName().equals("rent"))
                            System.out.println("--------------------------");

                        Object invoke = method.invoke(bookService, args);

                        return invoke;
                    }
                });

        bookService.rent("sun");
    }

    @Test
    public void cglibProxy(){
        //cglib 자바 하위 호환성이 별로 좋지 않음, 스프링, 하이버 네이트에서 사용 보통 자바 버전이랑 같이 배포함
        //상속 불가능한 클래스는 생성이 불가능하다. 상속해서 만듦

        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new DefaultBookService();

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                return method.invoke(bookService,args);
            }
        };

        BookService bookService = (BookService) Enhancer.create(BookService.class, handler);

        bookService.rent("son");
    }

    @Test
    public void bytebuddyProxy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //상속 불가능한 클래스는 생성이 불가능하다듦. 만듦

        Class proxyClass = new ByteBuddy().subclass(DefaultBookService.class).method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {

            BookService bookService = new DefaultBookService();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(bookService, args);
            }
        }))
                .make().load(BookService.class.getClassLoader()).getLoaded();
        BookService bookService = (BookService) proxyClass.getConstructor().newInstance();

        bookService.rent("sun");

    }
    
}