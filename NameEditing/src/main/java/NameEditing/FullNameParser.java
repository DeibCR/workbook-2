package NameEditing;

import java.util.Scanner;

public class FullNameParser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //User enter their name
        System.out.println("""
                Please enter your NAME in one of this formats:\s
                -First Last\s
                -First Middle Last\
                """);
        String fullName = sc.nextLine().trim();


        //Split the input in or ++ spaces and saved in an array
        //Divide los datos recibidos por espacios y los separa en una lista
        String[] nameSplit = fullName.split("\\s+");
        String firstName = "";
        String middleName = "none";
        String lastName = "";

        // Read the parts of the input and process
        // Cuenta las partes de la entrada del Usuario y las procesa
        if (nameSplit.length == 2) {
            firstName = nameSplit[0]; //First Name
            lastName = nameSplit[1];// :ast Name
        } else if (nameSplit.length == 3) {
            firstName = nameSplit[0];
            middleName = nameSplit[1];
            lastName = nameSplit[2];

        } else {
            System.out.println("The format that you entered is Invalid");
            return;
        }

        // display name
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);


    }


}
