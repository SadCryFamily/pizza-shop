package com.app.pizzashop.dto;

import com.app.pizzashop.dao.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullCustomerInfoDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private Date regDate;

}
