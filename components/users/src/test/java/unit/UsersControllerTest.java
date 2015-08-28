package unit;

import com.websiteskeleton.users.UsersController;
import org.junit.*;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UsersControllerTest {
    @InjectMocks UsersController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        controller = new UsersController();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testGetIndex() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"));
    }

    @Test
    public void testGetUsers() throws Exception {
        String sampleJson = "[" +
            "{\"name\":\"Bob\"}," +
            "{\"name\":\"Sue\"}" +
        "]";

        mockMvc.perform(get("/users"))
            .andExpect(status().isOk())
            .andExpect(content().string(sampleJson))
            .andExpect(header().string("content-type", "application/json"));
    }
}