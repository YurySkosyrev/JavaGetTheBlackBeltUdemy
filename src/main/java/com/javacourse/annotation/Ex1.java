package com.javacourse.annotation;

import java.lang.annotation.*;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("com.javacourse.annotation.Xiaomi");
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1;
        System.out.println("Annotation info from Xiaomi class: " +
                sm1.OS() + ", " + sm1.yearOfCompanyCreation());

        Class iphoneClass = Class.forName("com.javacourse.annotation.Iphone");
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm2 = (SmartPhone) annotation2;
        System.out.println("Annotation info from Iphone class: " +
                sm2.OS() + ", " + sm2.yearOfCompanyCreation());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    String OS() default "Android";
    int yearOfCompanyCreation() default 2010;
}

//with default values
@SmartPhone
class Xiaomi{
    String model;
    double Price;
}

@SmartPhone(OS="IOS", yearOfCompanyCreation = 1976)
class Iphone{
    String model;
    double Price;
}