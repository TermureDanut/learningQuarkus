package org.quarkus.learning;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

/*
* native test, it is executed with mvn verify "-Pnative" and executes the JVM tests before then triggers GraalVM to generate a native binary
* and runs the native test on the binary
*/

@QuarkusIntegrationTest
public class NativeBookResourceTest {
    @Test                       /// you can override a test form the JVM tests to work on the native test
    public void shouldGetBookById(){
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).pathParams("id", 1).
                when().get("/api/books/{id}").
                then().statusCode(200).body("title", is("book1")).
                body("author", is("author1")).
                body("year", is(2024)).
                body("genre", is("IT"));

    }
}
