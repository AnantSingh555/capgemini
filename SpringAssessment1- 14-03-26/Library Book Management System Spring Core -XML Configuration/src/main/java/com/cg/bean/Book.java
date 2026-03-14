package com.cg.bean;

public class Book {
    private int bookId;
    private String title;
    private String author;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void displayBookDetails(){
        System.out.println("Book Details:");
        System.out.println("------------------------------");
        System.out.println("Book Id: \t"+bookId);
        System.out.println("Book Title: \t"+title);
        System.out.println("Book Author: \t"+author);
    }
}
