package com.smart.controller;

public class A {

    public static void main(String[] args) {
        singleton obj =  singleton.getInstance();
        singleton obj1 =  singleton.getInstance();
        System.out.println(obj);
        System.out.println(obj1);
    }
}
