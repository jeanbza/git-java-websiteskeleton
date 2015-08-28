package acceptance.restassured;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProductsTest {
    @Test
    public void testGetProducts() {
        get("http://127.0.0.1:8080/applications/core/products")
            .then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"))
            .and().assertThat().body("get(0).name", equalTo("Super Glue"))
            .and().assertThat().body("get(1).name", equalTo("Kool-Aide"));
    }
}
