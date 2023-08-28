package com.tinkoff.education;

import com.tinkoff.education.domain.Client;
import com.tinkoff.education.resource.ClientResource;
import com.tinkoff.education.service.ClientService;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientResource.class)
public class ClientResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientResource clientResource;

    @BeforeEach
    public void setup() {
        Authentication auth = new UsernamePasswordAuthenticationToken(
            "admin", "password", Collections.singletonList(() -> "ADMIN")
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Test
    public void testGetAllClients() throws Exception {
        Client client1 = new Client(1, "John Doe", "New York");
        Client client2 = new Client(2, "Alice Smith", "San Francisco");
        List<Client> clients = Arrays.asList(client1, client2);

        when(clientService.getAllClients()).thenReturn(clients);

        mockMvc.perform(get("/clients"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].fullName").value(client1.getFullName()))
            .andExpect(jsonPath("$[1].fullName").value(client2.getFullName()));
    }

    @Test
    public void testGetClientById() throws Exception {
        Client client = new Client(1, "John Doe", "New York");

        when(clientService.getClientById(1)).thenReturn(client);

        mockMvc.perform(get("/clients/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.fullName").value(client.getFullName()));
    }

}
