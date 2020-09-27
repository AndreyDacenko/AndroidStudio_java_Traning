package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

	    int[] ages = {12, 14, 16, 18, 20};
	    ages[2] = 10;
        System.out.println(ages.length);
        System.out.println(Arrays.toString(ages));

    ArrayList newages = new ArrayList();
        newages.add(12);
        newages.add(14);
        newages.add(16);
        newages.add(18);
        newages.add(1,33);
        newages.remove(0);
        System.out.println(newages.get(2));
        System.out.println(newages);
        System.out.println(newages.toString());

//----------------------------------------------------------------------------------------------------------------------

        HashMap phones = new HashMap();
        phones.put("Nokia", 900);
        phones.put("Siemens", 700);
        phones.put("Motorolla", 800);
        phones.put("Philips", 500);
        System.out.println(phones.get("Siemens"));
        System.out.println(phones.toString());
        System.out.println(phones.size());

//----------------------------------------------------------------------------------------------------------------------

        int i = 0;
        while (i < 10){
            System.out.println("i= " + i);
            i+=1;
        }

        for (int j =  0; j < 10; j++){
            System.out.println("j= " + j);
        }

        String[] newphones = {"nokia", "siemens", "motorola", "philips"};
        for (String newphone : newphones){
            System.out.println(newphone);
        }

        ArrayList<String> newphones1 = new ArrayList();
        newphones1.add("nokia");
        newphones1.add("siemens");
        newphones1.add("motorola");
        newphones1.add("philips");
        for (String newphone1 : newphones1){
            System.out.println(newphone1);
        }

        class Client{
            int amountofPurchases;
            String name;

            public boolean hasDiscount(){
                if (amountofPurchases >= 1000){
                    return true;
                } else {
                    return false;
                }
            }
            public void hellowClient(){
                if (hasDiscount()){
                    System.out.println("Hellow " + name + ", you have discount!");
                } else {
                    System.out.println("Hellow " + name + " !");
                }
            }
        }

        Client andrey = new Client();
        andrey.name = "Andrey";
        andrey.amountofPurchases = 800;

        Client dima = new Client();
        dima.name = "Dima";
        dima.amountofPurchases = 1200;

        System.out.println(andrey.amountofPurchases);
        System.out.println(andrey.hasDiscount());

        andrey.hellowClient();
        dima.hellowClient();
    }
}
