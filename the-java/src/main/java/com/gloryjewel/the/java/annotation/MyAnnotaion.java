package com.gloryjewel.the.java.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 기본 값은 class 주석과 같기 때문에 class 에만 남아있고 메모리에도 로딩 하기 위해서는 runtime을 해줘야함
@Target({ElementType.TYPE, ElementType.FIELD}) // 사용하는 필드를 지정해 줄 수 있
@Inherited // 상속 가능
public @interface MyAnnotaion {

    String name() default "youngju";

    int number() default 100;

    String value(); // value 를 사용하면 해당 변수 명을 명시하지 않고 쓸 수 있다. 하나만 사용할 때 유용


}
