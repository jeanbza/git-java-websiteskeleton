package unit;

import com.websiteskeleton.users.UsersUiController;
import org.junit.*;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UsersUiControllerTest {
    @InjectMocks UsersUiController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        controller = new UsersUiController("foo bar");
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testGetIndex() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"));
    }

    @Test
    public void testGetHealth() throws Exception {
        mockMvc.perform(get("/health"))
            .andExpect(status().isOk())
            .andExpect(content().string("OK: foo bar"))
            .andExpect(header().string("content-type", "application/json"));
    }
}
