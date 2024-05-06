package com.turkcell.rentacar.inventoryService.api.controller;

import com.turkcell.rentacar.inventoryService.business.abstracts.BrandService;
import com.turkcell.rentacar.inventoryService.business.dto.request.brands.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.CreatedBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/inventoryservice/api/v1/brands")
public class BrandsController {
    private BrandService brandService; //Ioc

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.add(createBrandRequest);
    }
}
