package products;

import com.websiteskeleton.products.ProductsController;
import org.junit.*;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ProductsControllerTest {
    @InjectMocks ProductsController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        controller = new ProductsController();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testGetUsers() throws Exception {
        String sampleJson = "[" +
            "{\"name\":\"Super Glue\"}," +
            "{\"name\":\"Kool-Aide\"}" +
        "]";

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(content().string(sampleJson))
            .andExpect(header().string("content-type", "application/json"));
    }
}
