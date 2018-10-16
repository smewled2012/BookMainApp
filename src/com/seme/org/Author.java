package com.seme.org;

import java.util.ArrayList;

public class Author {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNum;
    private ArrayList<Book> books;

    public Author() {
        books=new ArrayList<>();
    }

    public Author(String firstName, String lastName, String emailAddress, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNum = phoneNum;
        books=new ArrayList<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void addBooks(Book book1){
        this.books.add(book1);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
