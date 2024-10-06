package com.pluralsight;

import java.util.Scanner;


public class Library {

    static Scanner principalScanner = new Scanner(System.in);


    static Book[] books = new Book[20];//Array that holds 20 Books

    public static void main(String[] args) {
        booksArray(); //Call to the method that initialize the array (array declare out of the main method)

        boolean keepCount = true; // Counter for the Home Screen

        while (keepCount) {
            System.out.println(""" 
                    *** Welcome to the Neighborhood Library ***
                    
                     1. Show Available Books
                    
                     2. Show Checked out Books
                    
                     3. Exit
                    
                     Please type the option you want to access: (1, 2, or 3)""");

            int option = principalScanner.nextInt(); //read the user prompt
            principalScanner.nextLine();


            switch (option) {
                case 1:
                    showAvailableBooks(); // Call to method that shows available books ---> check out a book --> ask Book ID --> ask the name of the user
                    break;

                case 2:
                    showCheckOutBooks(); // Call to method that display check out books
                    break;

                case 3:
                    System.out.println("Exiting the neighborhood library");
                    keepCount = false; // Ends the loop to exit
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    break;
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

    //Show all the books that are not check out
    private static void showAvailableBooks() {
        System.out.println("\n Available Books ");
        boolean check = false;
        for (Book book : books) { //For every object book from the class book in the array book
            if (!book.isCheckedOut()) { //And if the method ischeckedOut return a null value
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", ISBN: " + book.getIsbn()); //print every book available to check out
                check = true;
            }
        }
        if (!check) { // error check point
            System.out.println("Sorry we do not have available books at the moment, please check back later");
        } else {
            promptCheckOut(); // Init of method that ask the user to check out a book from the past list, using the book id
        }
    }


    //Show all the books that are check out
    private static void showCheckOutBooks() {
        System.out.println("\n Checked Out Books ");
        boolean check = false;
        for (Book book : books) { //For every object book from the class book in the array book
            if (book.isCheckedOut()) {  //And if the method ischeckedOut return a true value
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Checked out to: " + book.getCheckOutTo()); //print every check out book and the name of the person who check out the book
                check = true;
            }
        }
        if (!check) { // error check f there is no books check out
            System.out.println(" No books checked out. ");
        } else {
            promptCheckIn(); // init of method that ask the user to check in a book from the past check-out list, using the book id
        }

    }

    //Prompt the user to check out
    private static void promptCheckOut() {
        System.out.println("\n Would you like to check out a book? Enter the book Id or type 'X' to go back:");
        String type = principalScanner.nextLine();
        if (!type.equalsIgnoreCase("X")) {// compare if the user prompt ignoring Up or lower case is different to X
            try { // Test for error in user typing
                int bookId = Integer.parseInt(type); //If the user prompt if different from x, parse  that String argument and return an Int, to match the variable type  int "ID" in class book.
                checkOutBook(bookId); //Pass the new variable (ID of the book you are trying to check out ) to a method that gonna used to find and compare
            } catch (NumberFormatException e) { //Code to execute in case of error of user typing the ID
                System.out.println("Invalid ID. Please enter the book ID.");
            }
        }
    }

    //Prompt the user to check in
    private static void promptCheckIn() {
        System.out.println("\n Would you like to check in a book? Enter the book Id or type 'X' to go back:");
        String type = principalScanner.nextLine();
        if (!type.equalsIgnoreCase("X")) {// compare if the user prompt ignoring Up or lower case is different to X
            try { // Test for error in user typing
                int bookId = Integer.parseInt(type); //Parses a String argument and return an Int, to match the variable int "ID" in class book
                checkInBook(bookId);
            } catch (NumberFormatException e) { //Code to execute in case of error of user typing the ID
                System.out.println("Invalid ID. Please enter the book ID.");
            }
        }
    }

    //Check out book by ID
    private static void checkOutBook(int bookID) {
        Book book = findBookID(bookID);
        if (book != null && !book.isCheckedOut()) {
            System.out.println("Enter your name to check out the book");
            String name = principalScanner.nextLine();
            book.checkOut(name);
        } else {
            System.out.println("That book ID doesn't match our records");
        }
    }

    //Check in book by ID
    private static void checkInBook(int bookID) {
        Book book = findBookID(bookID);
        if (book != null && book.isCheckedOut()) {
            book.checkIn();
        } else {
            System.out.println("That book ID doesn't match our records");
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
