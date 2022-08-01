package com.app.pizzashop.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FillProductDto {

    private Long id;

    private String productName;

    private String productDescription;

    private String productPrice;

}
