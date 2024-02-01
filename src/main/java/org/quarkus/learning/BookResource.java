package org.quarkus.learning;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/books")                             /// general path of the class
@Produces(MediaType.APPLICATION_JSON)           /// promises that all the methods in the class return a JSON
public class BookResource {
    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;
    @GET
    public List<Book> getAllBooks(){
        logger.info("Returns all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")                         /// appended path to the path of the class
    @Produces(MediaType.TEXT_PLAIN)             /// overrides for this method and promises that this method returns TEXT and not JSON
    public int countAll(){
        logger.info("Returns the number of books");
        return bookRepository.countAll();
    }

    @GET
    @Path("/{id}")                           /// path param
    public Optional<Book> getBook (@PathParam("id") int id){            /// PathParam to link the method param to the path param
        logger.info("Returns a book by id");
        return bookRepository.getBook(id);
    }
}
