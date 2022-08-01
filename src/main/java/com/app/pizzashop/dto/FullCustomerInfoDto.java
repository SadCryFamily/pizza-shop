package com.app.pizzashop.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
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
