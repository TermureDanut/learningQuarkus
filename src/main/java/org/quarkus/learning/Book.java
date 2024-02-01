package org.quarkus.learning;

public class Book {
    public int id;
    public String title;
    public String author;
    public int year;
    public String genre;

    public Book(int id, String title, String author, int year, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }
}
