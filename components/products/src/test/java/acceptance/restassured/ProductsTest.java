package acceptance.restassured;

import org.junit.*;
import org.mockserver.client.server.MockServerClient;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ProductsTest {
    private MockServerClient mockServer;

    @Before
    public void setup() {
        mockServer = startClientAndServer(6789);
    }

    @Test
    public void testGetProducts() {
        mockServer
            .when(request().withMethod("GET").withPath("/external-product"))
            .respond(response().withStatusCode(200).withBody("Some External Product"));

        get("http://127.0.0.1:8080/applications/core/products")
            .then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"))
            .and().assertThat().body("get(0).name", equalTo("Super Glue"))
            .and().assertThat().body("get(1).name", equalTo("Kool-Aide"))
            .and().assertThat().body("get(2).name", equalTo("Some External Product"));
    }
}
