package com.pluralsight.donuts;

public class DonutShop {

    public static void main(String[] args) {
        Donut d= new Donut("Big fluffy Donut with cherry on top",499,3.99);
        Donut d2= new Donut("Chocolate cake donut",399,2.99);


        System.out.println(d);
        //System.out.println(d2);
        printDonut(d);
        printDonutAsCSV(d);




    }

    public static void printDonut(Donut d){
        System.out.println(d.getDescription());
        System.out.printf("$%.2f\n", d.getPrice());

    }

    public static void printDonutAsCSV(Donut d){
        System.out.print(d.getDescription());
        System.out.print(",");
        System.out.print(d.getCalories());
        System.out.print(",");
        System.out.print(d.getPrice());
    }
}
