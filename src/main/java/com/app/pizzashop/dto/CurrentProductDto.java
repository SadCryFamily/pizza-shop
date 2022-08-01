package com.app.pizzashop.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentProductDto {

    private String productName;

    private String productDescription;

    private String productPrice;

}
