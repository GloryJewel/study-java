package com.gloryjewel.the.java.reflection;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class HumanTests {

    @Test
    public void getReflection() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<?> humanClass = Class.forName("com.gloryjewel.the.java.reflection.Human");

//        Constructor constructor = humanClass.getConstructor(null);
//        Human human = (Human) constructor.newInstance(null);
        Constructor constructor = humanClass.getConstructor(String.class);
        Human human = (Human) constructor.newInstance("youngju");
        System.out.println(human.name);

        Field fieldA = Human.class.getDeclaredField("A");
        System.out.println(fieldA.get(null));
        fieldA.set(null, "AAAAAAA");
        System.out.println(fieldA.get(null));

        Field fieldB = Human.class.getDeclaredField("B");
        fieldB.setAccessible(true);
        System.out.println(fieldB.get(human));
        fieldB.set(human, "AAAAAAA");
        System.out.println(fieldB.get(human));

        Method methodC = Human.class.getDeclaredMethod("c");
        methodC.invoke(human);

        Method method = Human.class.getDeclaredMethod("sum", int.class, int.class);
        System.out.println(method.invoke(human, 1,2));

    }
}