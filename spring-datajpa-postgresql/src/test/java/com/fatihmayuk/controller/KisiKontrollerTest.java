package com.fatihmayuk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatihmayuk.dto.KisiDto;
import com.fatihmayuk.service.KisiService;
import com.fatihmayuk.service.impl.KisiServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = KisiKontroller.class)
public class KisiKontrollerTest {

    private final static String CONTENT_TYPE = "application/json";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private KisiServiceImpl kisiService;


    @Test
    void whenValidInput_thenReturns200() throws Exception {
        //given
        KisiDto kisi = KisiDto.builder().adi("fatih").soyadi("mayuk").build();

        //when
        ResultActions actions = mockMvc.perform(post("/kisi")
                .contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(kisi)));

        //then
        ArgumentCaptor<KisiDto> captor = ArgumentCaptor.forClass(KisiDto.class);
        verify(kisiService,times(1)).save(captor.capture());
        assertThat(captor.getValue().getAdi()).isEqualTo("fatih");
        assertThat(captor.getValue().getSoyadi()).isEqualTo("mayuk");
        actions.andExpect(status().isOk());

    }

    @Test
    void whenValidInput_thenReturns400() throws Exception {
        //given

        //when
        ResultActions actions = mockMvc.perform(post("/kisi")
        .contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString("test-value")));

        //then
        actions.andExpect(status().isBadRequest());
    }
    @Test
    void whenInvalidInput_thenReturns400() throws Exception {
        //given
        KisiDto kisi = KisiDto.builder().soyadi("mayuk").build();

        //when
        ResultActions actions = mockMvc.perform(post("/kisi")
        .contentType(CONTENT_TYPE).content(objectMapper.writeValueAsString(kisi)));

        //then
        actions.andExpect(status().isBadRequest());
    }

    @Test
    void whenVallTumunuListele_thenReturns200() throws Exception {
        //given
        KisiDto kisi = KisiDto.builder().adi("fatih").soyadi("mayuk").build();
        when(kisiService.getAll()).thenReturn(Arrays.asList(kisi));

        //when
        MvcResult mvcResult =  mockMvc.perform(get("/kisi")
                .accept(CONTENT_TYPE)).andReturn();

        //then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(kisiService,times(1)).getAll();
        assertThat(objectMapper.writeValueAsString(Arrays.asList(kisi)))
                .isEqualToIgnoringWhitespace(responseBody);
    }

    @Test
    void whenVallTumunuListele_thenReturnsNoData() throws Exception {
        //given
        when(kisiService.getAll()).thenReturn(Collections.emptyList());

        //when
        MvcResult mvcResult =  mockMvc.perform(get("/kisi")
                .accept(CONTENT_TYPE)).andReturn();

        //then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(kisiService,times(1)).getAll();
        assertThat(objectMapper.writeValueAsString(Collections.emptyList()))
                .isEqualToIgnoringWhitespace(responseBody);
    }

}