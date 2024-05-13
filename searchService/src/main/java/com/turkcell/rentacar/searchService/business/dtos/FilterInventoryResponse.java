package com.turkcell.rentacar.searchService.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterInventoryResponse {
    private int brandId;
    private String brandName;
}
