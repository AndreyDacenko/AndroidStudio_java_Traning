package com.company;

public class Main {
    public static int summ (int a, int b){
        return a + b;
    }

    public static int summ (int a, int b, int g){
        return a + b + g;
    }

    public static float summ (float a, float b, float g){
        return a + b + g;
    }

    public static void main(String[] args) {
        System.out.println(summ(20, 30));
        System.out.println(summ(20.5f, 30.45f, 40.17f));
        System.out.println(summ(20, 30, 40));
    }
}
