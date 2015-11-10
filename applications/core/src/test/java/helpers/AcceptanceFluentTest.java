package helpers;

import com.websiteskeleton.core.Application;
import org.fluentlenium.adapter.FluentTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
public abstract class AcceptanceFluentTest extends FluentTest {
}