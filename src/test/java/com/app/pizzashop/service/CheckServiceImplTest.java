package com.app.pizzashop.service;

import com.app.pizzashop.dao.Check;
import com.app.pizzashop.mapper.CheckMapper;
import com.app.pizzashop.repository.CheckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CheckServiceImplTest {

    @MockBean
    private CheckRepository checkRepository;

    @Autowired
    private CheckService checkService;

    @Autowired
    private CheckMapper checkMapper;

    @Test
    public void addNewCheckByCustomerIdTest() {

        Long sum = 200L;

        Mockito.when(checkRepository.getCustomerCheckById(1L)).thenReturn(200L);

        Check newCheck = Check.builder()
                .totalSum(sum)
                .build();

        Mockito.when(checkRepository.save(newCheck)).thenReturn(newCheck);

        var mappedCheck = checkMapper.toSimpleDto(newCheck);
        var result = checkService.addNewCheckByCustomerId(1L);

        assertEquals(result.getTotalSum(), mappedCheck.getTotalSum());
    }
}