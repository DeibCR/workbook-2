package com.pluralsight;

public class Book {

    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkOutTo = checkOutTo!= null? checkOutTo: "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkOutTo = checkOutTo;
    }


    public void checkOut(String name) {
        if (!isCheckedOut) {
            this.isCheckedOut = true;
            this.checkOutTo = name;
            System.out.println("The book " + title + "has been checked out to:" + name + ".");
            String checkoutSuccessMsg = "The book %s has been checked out to %s.";   // Read from resource bundle
            System.out.printf(checkoutSuccessMsg, title, name);

        } else {
            System.out.println(title + "is checked out already. ");
        }


    }

    public void checkIn() {
        if (isCheckedOut) {
            this.isCheckedOut = false;
            System.out.println(title + " has been checked in by: " + checkOutTo + ".");
            this.checkOutTo = "";

        } else {
            System.out.println(title + "is not checked out.");
        }

    }

    @Override
    public String toString() {
        return "Book{" +
               "id=" + id +
               ", isbn='" + isbn + '\'' +
               ", title='" + title + '\'' +
               '}';
    }
}


