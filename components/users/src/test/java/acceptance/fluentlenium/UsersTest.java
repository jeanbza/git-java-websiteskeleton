package acceptance.fluentlenium;

import org.fluentlenium.adapter.FluentTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest extends FluentTest {
    private DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
    private WebDriver driver = new PhantomJSDriver(capabilities);

    @Override
    public WebDriver getDefaultDriver() {
        return driver;
    }

    @Test
    public void testGetIndex() {
        goTo("http://127.0.0.1:8080");
        assertThat(pageSource()).contains("Hello world!");
    }

    @Test
    public void testJavascript() {
        goTo("http://127.0.0.1:8080");
        assertThat(pageSource()).contains("Hello from javascript!");
    }

    @Test
    public void testGetHealth() {
        goTo("http://127.0.0.1:8080/health");
        assertThat(pageSource()).contains("OK: You are using application-test.yml!");
    }
}
