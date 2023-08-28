package com.tinkoff.education;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinkoff.education.domain.Car;
import com.tinkoff.education.resource.CarResource;
import com.tinkoff.education.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@WebMvcTest(CarResource.class)
public class CarResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @BeforeEach
    public void setup() {
        // Аутентификация пользователя с ролью ADMIN перед каждым тестом
        Authentication auth = new UsernamePasswordAuthenticationToken(
            "admin", "password", Collections.singletonList(() -> "ADMIN")
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Test
    public void testGetAllCars() throws Exception {
        Car car = new Car();
        car.setId(1L);
        car.setLicensePlate("ABC123");
        car.setModel("Toyota");

        Mockito.when(carService.getAllCars()).thenReturn(Collections.singletonList(car));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars")
                            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].licensePlate").value("ABC123"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].model").value("Toyota"));
    }


    @Test
    public void testCreateCar() throws Exception {
        Car car = new Car();
        car.setId(1L);
        car.setLicensePlate("ABC123");
        car.setModel("Toyota");

        Mockito.when(carService.createCar(Mockito.any(Car.class))).thenReturn(car);

        mockMvc.perform(MockMvcRequestBuilders.post("/cars")
                            .content(asJsonString(car))
                            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.licensePlate").value("ABC123"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Toyota"));
    }

    // Тесты для методов updateCar и deleteCar

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
