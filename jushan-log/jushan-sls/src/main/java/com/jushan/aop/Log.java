package com.jushan.aop;

import java.lang.annotation.*;

/**
 * @author Hello
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log{

    String value() default "未命名";
}
