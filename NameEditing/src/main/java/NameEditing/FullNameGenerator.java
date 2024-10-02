package NameEditing;

import java.util.Scanner;

public class FullNameGenerator {
    private String firstName;
    private String middleName;
    private String lastname;
    private String suffix;


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

    public static void printName(FullNameGenerator name) {
        System.out.println(name.getFirstName());
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


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your First name: ");
        String firstName = scanner.nextLine().trim();


        System.out.println("Please enter your Middle name (If you have one): ");
        String middleName = scanner.nextLine().trim();

        System.out.println("Please enter yout Last Name: ");
        String lastname = scanner.nextLine().trim();

        System.out.println("Please enter your Suffix *If you have one): ");
        String suffix = scanner.nextLine().trim();

        FullNameGenerator nameGenerator = new FullNameGenerator(firstName, middleName, lastname, suffix);

        System.out.println("Full Name is: " + nameGenerator);


    }


}
