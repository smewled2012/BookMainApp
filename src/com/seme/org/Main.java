package com.seme.org;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // declare a scanner
        Scanner input = new Scanner(System.in);
        ArrayList<Book> listBooks = new ArrayList<>();
        ArrayList<Author> listAuthors= new ArrayList<>();



        //****************************** create a new book  *******************************************
        String addBook;
        do {
            Book book = new Book();
            System.out.println("Enter the title of the book ");
            String title = input.nextLine();
            book.setTitle(title);
            System.out.println("Enter the ISBN ");
            String isbn = input.nextLine();
            book.setISBN(isbn);

            // if the books tile and isbn is in the list of authors
             Author author = findAuthor(title, isbn, listAuthors);
             if(author!=null)
                 book.setAuthors(author);

            System.out.println("Do you wanna add another book ? yes/no");
            addBook=input.nextLine();
            listBooks.add(book);
        }while(addBook.equalsIgnoreCase("yes"));

        // display the list of books
        System.out.println("List of Books: ");
        for(Book eachbook: listBooks) {

            System.out.println("title :" + eachbook.getTitle() + "\nISBN : " + eachbook.getISBN()+"\nAuthor: "+ eachbook.getAuthors()+"\n");
        }

        //create an author

        //create an author and add as many authors as the use wants
        String addAuthor=" ";
        do{
            Author author = new Author();
            System.out.println("Enter the first name of the Author: ");
            String fname = input.nextLine();
            author.setFirstName(fname);
            System.out.println("Enter the last name :");
            String lname = input.nextLine();
            author.setLastName(lname);
            System.out.println("Enter the email");
            String email = input.nextLine();
            author.setEmailAddress(email);
            System.out.println("Enter the phone number");
            String phone = input.nextLine();
            author.setPhoneNum(phone);
            // adding as many books as the user want to an Author

            String addBooks =" ";
            do{
                Book book1 = new Book();
                System.out.println("Enter the title of the book you want to add");
                String title = input.nextLine();
                book1.setTitle(title);
                System.out.println("Enter the ISBN ");
                String isbn = input.nextLine();
                book1.setISBN(isbn);

                //checking if the book exists in the book list
                Book foundbook = findBookList(title,isbn,listBooks);

                if(foundbook!=null)
                    author.getBooks().add(foundbook);
                else
                    author.addBooks(book1);

               // author.addBooks(book1);

                System.out.println("Do you want to add more books to author ? yes/no");
                addBooks=input.nextLine();

            }while(addBooks.equalsIgnoreCase("yes"));

            System.out.println("Do you want to add another author ? yes/no");
            addAuthor=input.nextLine();
            listAuthors.add(author);

        }while(addAuthor.equalsIgnoreCase("yes"));

        System.out.println("the size of the author: "+ listAuthors.size());




        // ****************************to see the list of author and the books they wrote ****************

        for(Author eachauthor: listAuthors) {
            System.out.println("Author detail: \nFirstName :" + eachauthor.getFirstName() + "\nLastName: " + eachauthor.getLastName() +
                    "\nBooks:");
            System.out.println("the size of the books for each author : "+ eachauthor.getBooks().size());
            for(Book otherbook:eachauthor.getBooks()){
                System.out.println("Title :" + otherbook.getTitle() + "\nISBN: " +otherbook.getISBN());
            }

        }

    //******************************** display the list of books with their authors  ********************************

        System.out.println("List of Books after the author list is created : ");

        for(Book eachbook: listBooks) {
            for (Author author: listAuthors) {
                //   Author author = findAuthor(String title, isbn, listAuthors);
                if (author.getBooks().contains(eachbook)) {

                    System.out.println("isnot working !");
                    System.out.println("title :" + eachbook.getTitle() + "\nISBN : " + eachbook.getISBN() + "\nAuthor: " + author.getFirstName() + "\n");
                }
            }
        }




    }


    private static Author findAuthor(String title, String isbn, ArrayList<Author> listAuthors) {
        Author found = null;
        for(Author eachAuthor:listAuthors){
            if(eachAuthor.getBooks().contains(title)&&eachAuthor.getBooks().contains(isbn)){
                found =eachAuthor;
            }
        }
        return found;

    }

    private static Book findBookList(String title, String isbn, ArrayList<Book> listBooks) {
        Book bookfound = null;
        for(Book eachBook: listBooks) {
            if (eachBook.getTitle().equalsIgnoreCase(title)&&eachBook.getISBN().equalsIgnoreCase(isbn))
                bookfound=eachBook;
        }
        return  bookfound;

    }


}
