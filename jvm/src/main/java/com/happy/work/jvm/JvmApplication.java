package com.happy.work.jvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class JvmApplication {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        SpringApplication.run(JvmApplication.class, args);
        TestClassLoader testClassLoader = new TestClassLoader();
        Class<?> hello = testClassLoader.findClass("Hello");
        Object o = hello.newInstance();
        hello.getMethod("hello").invoke(o);
    }

}
