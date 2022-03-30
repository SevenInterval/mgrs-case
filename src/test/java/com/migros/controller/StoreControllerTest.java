package com.migros.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.migros.dto.CourierDto;
import com.migros.dto.Geolocation;
import com.migros.dto.StoreDto;
import com.migros.service.IStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StoreController.class)
class StoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStoreService storeService;

    @Test
    public void storeShoudReturnCreatedFromServiceSaveStore() throws Exception {
        StoreDto storeDto = new StoreDto();
        storeDto.setId(1L);
        storeDto.setName("MMM Carousel");
        storeDto.setLat(45.1654789);
        storeDto.setLng(28.5651651);
        storeDto.setCreateTime(LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String storeString = objectMapper.writeValueAsString(storeDto);
        mockMvc.perform(post("/api/store").content(storeString).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void storeShoudReturnOkFromServiceGetAllStores() throws Exception {
        mockMvc.perform(get("/api/store").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }
}