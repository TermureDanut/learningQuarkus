package org.quarkus.learning;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest                            /// JUnit annotation
public class BookResourceTest {
    @Test                               /// JUnit annotation
    public void shouldGetAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).             /// using RestAssured to implement test on quarkus endpoints
                when().get("/api/books").
                then().statusCode(200).body("size()", is(3));
    }
    @Test
    public void shouldCountAllBooks(){
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
                when().get("/api/books/count").
                then().statusCode(200).body(is("3"));
    }
    @Test
    public void shouldGetBookById(){
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).pathParams("id", 1).
                when().get("/api/books/{id}").
                then().statusCode(200).body("title", is("book1")).
                body("author", is("author1")).
                body("year", is(2024)).
                body("genre", is("IT"));

    }

    /* mvn test to run all test classes annotated with @QuarkusTest
       mvn test starts a new profile (test) on a new port 8081 and fully starts the app, runs the tests and stops the app
    */
}
