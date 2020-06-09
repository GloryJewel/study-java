package com.gloryjewel.the.java.bytecode;

import org.junit.jupiter.api.Test;

public class ClassLoaderTests {

    /** *
     * boot_loader -> plaform_loader -> app_loader
     * boot_loader 부터 순서대로 class 파일을 찾음
     */
    @Test
    public void loader(){

        ClassLoader classLoader = ClassLoaderTests.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
