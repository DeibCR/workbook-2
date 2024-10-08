package com.pluralsight;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Library {

    static Scanner principalScanner = new Scanner(System.in);
    static Book[] books = new Book[20];//Array that holds 20 Books
    static ResourceBundle messages; // To hold the 2 language options


    public static void main(String[] args) {
        selectLanguage(); // Language Selection
        booksArray(); //Call to initialize the array

        boolean keepCount = true; // Counter for the Home Screen

        while (keepCount) {
            System.out.println(messages.getString("welcome"));
            System.out.println(messages.getString("option1"));
            System.out.println(messages.getString("option2"));
            System.out.println(messages.getString("option3"));
            System.out.println(messages.getString("choose_option"));

            int option = principalScanner.nextInt(); //Read the user prompt
            principalScanner.nextLine();


            switch (option) {
                case 1:
                    showAvailableBooks(); // Call to method that shows available books ---> check out a book --> ask Book ID --> ask the name of the user
                    break;

                case 2:
                    showCheckOutBooks(); // Call to method that display check out books
                    break;

                case 3:
                    System.out.println(messages.getString("exit_message"));
                    keepCount = false; // Ends the loop to exit
                    break;
                default:
                    System.out.println(messages.getString("invalid_option"));

            }//
        }
    }// End of switch 1st menu

    private static void booksArray() { // Hard code books array
        books[0] = new Book(1, "978-3-16-148410-0", "The Catcher in the Rye", false, "");
        books[1] = new Book(2, "978-1-40-289462-6", "To Kill a Mockingbird", false, "");
        books[2] = new Book(3, "978-0-14-028329-7", "1984", false, "");
        books[3] = new Book(4, "978-0-7432-7356-5", "The Great Gatsby", false, "");
        books[4] = new Book(5, "978-1-5011-2637-5", "The Silent Patient", false, "");
        books[5] = new Book(6, "978-0-06-245773-8", "Where the Crawdads Sing", false, "");
        books[6] = new Book(7, "978-0-312-42727-8", "The Da Vinci Code", false, "");
        books[7] = new Book(8, "978-0-452-28423-4", "Brave New World", false, "");
        books[8] = new Book(9, "978-0-452-28240-7", "Fahrenheit 451", false, "");
        books[9] = new Book(10, "978-0-06-112008-4", "Of Mice and Men", false, "");
        books[10] = new Book(11, "978-0-307-74149-8", "The Road", false, "");
        books[11] = new Book(12, "978-1-4767-4658-6", "The Night Circus", false, "");
        books[12] = new Book(13, "978-1-250-07578-5", "The Hunger Games", false, "");
        books[13] = new Book(14, "978-0-7432-7355-8", "Angels and Demons", false, "");
        books[14] = new Book(15, "978-0-7432-7357-2", "The Lost Symbol", false, "");
        books[15] = new Book(16, "978-1-250-11991-2", "The Ballad of Songbirds and Snakes", false, "");
        books[16] = new Book(17, "978-0-7434-2725-8", "Ender's Game", false, "");
        books[17] = new Book(18, "978-0-307-74438-3", "The Girl on the Train", false, "");
        books[18] = new Book(19, "978-1-4767-0767-9", "Gone Girl", false, "");
        books[19] = new Book(20, "978-0-553-38407-3", "The Shining", false, "");


    }

    //Method to set the app language
    private static void selectLanguage(){
        System.out.println(" Select your preferred language / Seleccione su idioma preferido:");
        System.out.println("1. English");
        System.out.println("2. Spanish");

        int chooseLanguage = principalScanner.nextInt();
        principalScanner.nextLine();

        switch (chooseLanguage){
            case 2:
                setLanguage("es", "ES"); //Spanish
                break;
            default:
                setLanguage("en", "US"); //Default to English
        }
    }

    private static void setLanguage(String lang, String country){
        Locale locale = new Locale (lang, country);
        messages = ResourceBundle.getBundle("messages", locale);
    }

    //Show all the books that are not check out
    private static void showAvailableBooks() {
        System.out.println(messages.getString("showAvailableBooks"));
        boolean check = false;
        for (Book book : books) { //For every object book from the class book in the array book
            if (!book.isCheckedOut()) { //And if the method ischeckedOut return a null value
                System.out.println(messages.getString("showList1") + book.getId() + " " + messages.getString("showList2") + book.getTitle() + " " + messages.getString("showList3")+ book.getIsbn()); //print every book available to check out

                check = true;
            }
        }
        if (!check) { // error check point
            System.out.println(messages.getString("errorShow"));
        } else {
            principalScanner.nextLine();
            promptCheckOut(); // Init of method that ask the user to check out a book from the past list, using the book id
        }
    }


    //Show all the books that are check out
    private static void showCheckOutBooks() {
        System.out.println(messages.getString("showCheckedOutBooks"));
        boolean check = false;
        for (Book book : books) { //For every object book from the class book in the array book
            if (book.isCheckedOut()) {  //And if the method ischeckedOut return a true value
                System.out.println(messages.getString("showList11") + book.getId()  + " " + messages.getString("showList22")+ book.getTitle() + " " + messages.getString("showList33") + book.getCheckOutTo()); //print every check out book and the name of the person who check out the book
                check = true;
            }
        }
        if (!check) { // error check f there is no books check out
            System.out.println(messages.getString("errorShow1"));
            principalScanner.nextLine();
        } else {
            principalScanner.nextLine();
            promptCheckIn(); // init of method that ask the user to check in a book from the past check-out list, using the book id
        }

    }

    //Prompt the user to check out
    private static void promptCheckOut() {
        System.out.println(messages.getString("promptCheckOut"));
        String type = principalScanner.nextLine();
        if (!type.equalsIgnoreCase("X")) {// compare if the user prompt ignoring Up or lower case is different to X
            try { // Test for error in user typing
                int bookId = Integer.parseInt(type); //If the user prompt if different from x, parse  that String argument and return an Int, to match the variable type  int "ID" in class book.
                checkOutBook(bookId); //Pass the new variable (ID of the book you are trying to check out ) to a method that gonna used to find and compare
            } catch (NumberFormatException e) { //Code to execute in case of error of user typing the ID
                System.out.println(messages.getString("errorPromptOut"));
            }
        }
    }

    //Prompt the user to check in
    private static void promptCheckIn() {
        System.out.println(messages.getString("promptCheckIn"));
        String type = principalScanner.nextLine();
        if (!type.equalsIgnoreCase("X")) {// compare if the user prompt ignoring Up or lower case is different to X
            try { // Test for error in user typing
                int bookId = Integer.parseInt(type); //Parses a String argument and return an Int, to match the variable int "ID" in class book
                checkInBook(bookId);
            } catch (NumberFormatException e) { //Code to execute in case of error of user typing the ID
                System.out.println(messages.getString("errorPromptIn"));
            }
        }
    }

    //Check out book by ID
    private static void checkOutBook(int bookID) {
        Book book = findBookID(bookID);
        if (book != null && !book.isCheckedOut()) {
            System.out.println(messages.getString("checkOutBook"));
            String name = principalScanner.nextLine();
            book.isCheckedOut= true;
            book.checkOutTo= name;
            System.out.println(messages.getString("message01") + book.getTitle() + messages.getString("message02") + book.checkOutTo +".");
           principalScanner.nextLine();
           // book.checkOut(name);

        } else {
            System.out.println(messages.getString("checkOutBookError"));
        }
    }

    //Check in book by ID
    private static void checkInBook(int bookID) {
        Book book = findBookID(bookID);
        if (book != null && book.isCheckedOut()) {
            book.isCheckedOut= false;
            System.out.println(book.getTitle()  + " " + messages.getString("checkInn") + book.checkOutTo + ".");
            book.checkOutTo="";

            //book.checkIn();
        } else {
            System.out.println(messages.getString("checkOutBookError"));
        }
    }


    private static Book findBookID(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

}
