package com.pluralsight.logic;

public class LogicExamples {

    public static void main(String[] args) {
        System.out.println("Hello");


        double area = 10 / 3;
        double remainder = 10.0 % 3.0;

        area = (double) 10 / 3;

        System.out.println(area);
        System.out.println(remainder);

        //Arithmetic operators
        // + - / * %
        // Increment/decrement operators
        // ++ --

        area = area + 1;
        System.out.println(area);

        area++;
        System.out.println(area);

        System.out.println(++area);

        System.out.println(++area + area++ + remainder++);

        System.out.println(area);
        System.out.println(remainder);

        float x = (float) remainder;
        System.out.println(x);

        float y = 7.99f;
        System.out.println(y);

        double z = 8.33f;
        System.out.println(z);

        System.out.printf("%.2f", z);

        //LOGIC
        //comparison operators
        // == != < > >= <= !

        boolean amIDone = false;
        int counter = 0;

        do {
            System.out.println("talking....words....");
            counter++;
            if (counter++ == 5) amIDone = true;
        } while (!amIDone);

        System.out.println(counter);

        counter =0;
        while (counter!=5){
            System.out.println("talking....words....");
            counter++;

        }

        for (int i=0; i<5; i++){
            System.out.println("Talking....");
        }

        if (counter>0){
            System.out.println("We talked about it");
        }




    }


}
