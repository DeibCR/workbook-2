package com.pluralsight.strings;

public class StringsAndLoops {

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.toLowerCase());

        String[] shoppingItems ={
                "Chair","Desktop screen", "Mouse XP3", "Headset", "Portable Hard drive",
                "CPU","Speakers", "Notepad", "Portable Screen","USB external port" };


                //Print the shopping list
        System.out.println("Shopping List:");
        for (String item: shoppingItems){
            System.out.println("- "+ item.toLowerCase());
        }




    }
}
