package com.example.effectivejava.chapter01.item01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HelloService eng = HelloService.of("eng");
        System.out.println(eng.hello());
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h->{
            System.out.println(h.hello());
        });

        Class<?> aClass = Class.forName("com.example.effectivejava.chapter01.item01");
        Constructor<?> constructor = aClass.getConstructor();
        HelloService helloService = (HelloService) constructor.newInstance();
        Class<?>[] declaredClasses = aClass.getDeclaredClasses();
    }
}
