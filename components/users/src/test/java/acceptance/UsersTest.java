package acceptance;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest extends FluentTest {
    // TODO: Move to more appropriate place
    @Test
    public void index() {
        goTo("http://127.0.0.1/applications/core");
        assertThat(pageSource()).contains("Hello world!");
    }

    // TODO: Move to more appropriate place
    @Test
    public void health_check_should_show_OK() {
        goTo("http://127.0.0.1:8080/applications/core/health");
        assertThat(pageSource()).contains("OK");
    }
}
