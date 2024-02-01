package org.quarkus.learning;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped                      /// ensures that only one instance of BookRepository is created and used
public class BookRepository {
    public List<Book> getAllBooks(){
        return List.of(
                new Book(1, "book1", "author1", 2024, "g"),
                new Book(2, "book2", "author2", 2024, "ge"),
                new Book(3, "book3", "author3", 2024, "gen")
        );
    }

    public int countAll(){
        return getAllBooks().size();
    }

    public Optional<Book> getBook (int id){
        List<Book> books = getAllBooks();
        for (Book book : books){
            if (book.id == id){
                return Optional.of(book);
            }
        }
        return Optional.empty();


        // return getAllBooks().stream().filter(bool -> book.id == id).findFirst();
    }
}
