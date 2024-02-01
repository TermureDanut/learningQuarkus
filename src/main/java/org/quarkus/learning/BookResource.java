package org.quarkus.learning;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/api/books")                             /// general path of the class
@Produces(MediaType.APPLICATION_JSON)           /// promises that all the methods in the class return a JSON
public class BookResource {
    @GET
    public List<Book> getAllBooks(){
        return List.of(
                new Book(1, "book1", "author1", 2024, "g"),
                new Book(2, "book2", "author2", 2024, "ge"),
                new Book(3, "book3", "author3", 2024, "gen")
        );
    }

    @GET
    @Path("/count")                         /// appended path to the path of the class
    @Produces(MediaType.TEXT_PLAIN)             /// overrides for this method an promises that this method returns TEXT and not JSON
    public int countAll(){
        return getAllBooks().size();
    }

    @GET
    @Path("/{id}")                           /// path param
    public Optional<Book> getBook (@PathParam("id") int id){            /// PathParam to link the method param to the path param
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
