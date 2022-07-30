package tacos;

import static org.hamcrest.Matchers.containsString;
import static
    org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
    org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static
    org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static
    org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import tacos.repository.IngredientRepository;
import tacos.repository.OrderRepository;
import tacos.repository.TacoRepository;
import tacos.repository.UserRepository;
import tacos.service.AdminService;

/**
 * todo Document type HomeControllerTest
 */
@WebMvcTest
@ExtendWith(SpringExtension.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @MockBean
    private IngredientRepository ingredientRepository;

    @MockBean
    private TacoRepository designRepository;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(content().string(
                containsString("Welcome to...")
            ));
    }

}
