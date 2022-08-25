package api.casino;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import api.casino.controller.rest.UserRestController;
import api.casino.repository.UserRepository;
import api.casino.service.UserService;

@WebMvcTest
public class UserRestControllerT {
	
	MockMvc mockMvc;
	
	
	@Mock
	UserRepository userRepository;
	@MockBean
	UserService userService;
	@Mock 
	UserRestController userRestController;
	UUID uuid;
	
	@BeforeEach
    void setUp() {
		
        final String id = "493410b3-dd0b-4b78-97bf-289f50f6e74f";
        uuid = UUID.fromString(id);

        mockMvc = MockMvcBuilders
                .standaloneSetup(userRestController)
                .build();
    }

	@Test
	void testListUsers() throws Exception{
		mockMvc.perform(get("/users"))
		.andExpect(status().isOk());
	}
}
