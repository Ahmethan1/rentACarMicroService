package com.turkcell.rentacar.inventoryService.business.dto.request.brands;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBrandRequest {
    @NotNull
    @Size (min = 2,max = 30)
    private String name;
}
