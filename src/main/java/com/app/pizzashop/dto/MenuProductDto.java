package com.app.pizzashop.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuProductDto {

    private String productName;

    private String productPrice;

}
