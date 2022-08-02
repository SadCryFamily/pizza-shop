package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Check;
import com.app.pizzashop.mapper.CheckMapper;
import com.app.pizzashop.service.CheckService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CheckControllerTest {

    @MockBean
    private CheckService checkService;

    @Autowired
    private CheckMapper checkMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCustomerCheckTest() throws Exception {

        Check check = Check.builder()
                .checkId(1L)
                .totalSum(200L)
                .build();

        var mappedCheck = checkMapper.toSimpleDto(check);

        Mockito.when(checkService.addNewCheckByCustomerId(1L)).thenReturn(mappedCheck);

        this.mockMvc.perform(get("/profile/{id}/check", 1))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalSum", Matchers.is(200)));

    }
}