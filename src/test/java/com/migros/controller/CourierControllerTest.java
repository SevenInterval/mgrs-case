package com.migros.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.migros.dto.CourierDto;
import com.migros.dto.Geolocation;
import com.migros.service.ICourierService;
import com.migros.service.IStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import java.time.LocalDateTime;


@WebMvcTest(CourierController.class)
class CourierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICourierService courierService;

    @MockBean
    private IStoreService storeService;

    @Test
    public void courierShoudReturnCreatedFromServiceSaveCourier() throws Exception {
        CourierDto courierDto = new CourierDto();
        courierDto.setCourier("Rıdvan");
        courierDto.setTime(LocalDateTime.now());
        Geolocation geolocation = new Geolocation();
        geolocation.setLat(45.1654789);
        geolocation.setLng(28.5651651);
        courierDto.setGeolocation(geolocation);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String courierString = objectMapper.writeValueAsString(courierDto);
        mockMvc.perform(post("/api/courier").content(courierString).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void courierShoudReturnOkFromServiceGetAllCouriers() throws Exception {
        mockMvc.perform(get("/api/courier").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void courierShoudReturnCourierListFromServiceTotalTravelDistance() throws Exception {
        mockMvc.perform(get("/api/courier/distance/1").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }


}