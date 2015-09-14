package acceptance.restassured;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class UsersTest {
    @Test
    public void testGetUsers() {
        get("http://127.0.0.1:8080/users")
            .then().assertThat().body(matchesJsonSchemaInClasspath("users-schema.json"))
            .and().assertThat().body("get(0).name", equalTo("Bob"))
            .and().assertThat().body("get(1).name", equalTo("Sue"));
    }
}
