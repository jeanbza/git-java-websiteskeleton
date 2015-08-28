package acceptance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BarTest {
    @Test
    public void testNothing() {
        assertThat("foo", equalTo("foo"));
    }
}
