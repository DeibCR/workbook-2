package NameEditing;

import java.util.Scanner;

public class FullNameGenerator {
    private final String firstName;
    private String middleName;
    private String lastname;
    private String suffix;

    static Scanner inputUser;


    public FullNameGenerator(String firstName, String middleName, String lastname, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastname = lastname;
        this.suffix = suffix;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSuffix() {
        return suffix;
    }


    @Override
    public String toString() {
        StringBuilder fullName = new StringBuilder();
        fullName.append(getFirstName()).append(" ");
        if (!getMiddleName().isEmpty()) {
            fullName.append(getMiddleName()).append(" ");
        }
        fullName.append(getLastname());
        if (!getSuffix().isEmpty()) {
            fullName.append(", ").append(getSuffix());
        }
        return fullName.toString();
    }

    public static void main(String[] args) {

        inputUser = new Scanner(System.in);


        System.out.println("Please enter your First name: ");
        String firstName = inputUser.nextLine().trim();


        System.out.println("Please enter your Middle name (If you have one): ");
        String middleName = inputUser.nextLine().trim();

        System.out.println("Please enter yout Last Name: ");
        String lastname = inputUser.nextLine().trim();

        System.out.println("Please enter your Suffix *If you have one): ");
        String suffix = inputUser.nextLine().trim();

        FullNameGenerator nameGenerator = new FullNameGenerator(firstName, middleName, lastname, suffix);

        System.out.println("Full Name is: " + nameGenerator);


    }


}
