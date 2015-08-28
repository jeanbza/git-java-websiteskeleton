package acceptance;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarTest extends FluentTest {
    @Test
    public void health_check_should_show_OK() {
        goTo("http://127.0.0.1:8080/applications/core/health");
        assertThat(pageSource()).contains("OK");
    }
}
