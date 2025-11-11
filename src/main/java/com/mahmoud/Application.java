package com.mahmoud;

import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = Micronaut.run(Application.class, args);
        for(BeanDefinition beanDefinition :applicationContext.getAllBeanDefinitions()){
            System.out.println(beanDefinition.getName());
        }
    }
}