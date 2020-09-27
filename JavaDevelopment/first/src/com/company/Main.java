package com.company;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.print("Hellow world");

//        byte num = 120;
//        int num1 = 130;
//        float num2 = 12.5f;
//        double num3 = 123.455446551d;
//        char one_symbol = 'A';
//        boolean true_or_false = true;
//        String text = "Hellow my dear friend!";
//        System.out.print(text);

//        System.out.print("Vvedite text: ");
//        Scanner vyvod = new Scanner(System.in);
//        System.out.println("Your text: " + vyvod.nextLine());

//        Scanner number = new Scanner(System.in);
//        float first, second, result;
//        System.out.print("First: ");
//        first = number.nextInt();
//        System.out.print("Second: ");
//        second = number.nextInt();
//        result = first / second;
//        System.out.printf("Result: " +  "%.2f", result);

//        for (int i = 1; i < 6; i++ ){
//            System.out.println(i);
//        }
//
//        boolean perem = true;
//        int j = 0;
//        while (perem){
//            System.out.println(j);
//            j +=1;
//            if (j > 10){
////                perem = false;
//                break;
//            }
//        }

//        int[] name = new int[] {4,8,15,16,23,42};
//        String nameString = Arrays.toString(name);
//        System.out.println(nameString);

//        int[][] array = new int[][] {{4,8},{15,16},{23,42}};
//        String arrayString = Arrays.deepToString(array);
//        System.out.print(arrayString);

//        -----------------------------------------------
        func(3,4);

    }
    public static void func(int a, int b) {
        int res = 1;
        for(int i = 0; i < b; i++)
            res *= a;
        System.out.print(res);
    }
//    ------------------------------------------

}
























