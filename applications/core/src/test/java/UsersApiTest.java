import helpers.AcceptanceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

public class UsersApiTest extends AcceptanceTest {
    @Value("${local.server.port}")
    private int port;

    @Test
    public void testGetUsers() {
        get("http://127.0.0.1:" + port + "/users")
            .then().assertThat().body("get(0).name", equalTo("Bob"))
            .and().assertThat().body("get(1).name", equalTo("Sue"));
    }
}
