package com.gloryjewel.the.java.bytecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

class ByteBuddyMainTests {

    @Test
    public void bytebuddyFirstLoad() throws IOException {

        //클래스 로더가 바이트 코드를 읽기전에 빨리 저장 해야함
        ClassLoader classLoader = ByteBuddyMainTests.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);

        new ByteBuddy().redefine(
                typePool.describe("com.gloryjewel.the.java.bytecode.TestTest").resolve()
                , ClassFileLocator.ForClassLoader.of(classLoader))
                .method(named("say")).intercept(FixedValue.value("hello"))
                .make().saveIn(new File("the-java/build/classes/java/main"));

        System.out.println("---------------------------------");

        System.out.println(new TestTest(null).say());
    }

}