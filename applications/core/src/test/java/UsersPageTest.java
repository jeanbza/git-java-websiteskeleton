import helpers.AcceptanceFluentTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class UsersPageTest extends AcceptanceFluentTest {
    @Value("${local.server.port}")
    private int port;

    @Test
    public void testGetIndex() {
        goTo("http://127.0.0.1:" + port);
        assertThat(pageSource()).contains("Hello world!");
    }

    @Test
    public void testGetHealth() {
        goTo("http://127.0.0.1:" + port + "/health");
        assertThat(pageSource()).contains("OK: You are using application-test.yml!");
    }
}
