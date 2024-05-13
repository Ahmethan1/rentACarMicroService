package com.turkcell.rentacar.inventoryService.api.controller;

import com.turkcell.rentacar.inventoryService.business.abstracts.BrandService;
import com.turkcell.rentacar.inventoryService.business.dto.request.brands.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dto.request.brands.UpdateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.CreatedBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.GetAllBrandsListItemDto;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.GetBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.UpdatedBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}") //api/v1/brands/5
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBrandResponse update(@Valid @PathVariable int id, @RequestBody UpdateBrandRequest brand) {
        return brandService.update(id, brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponse get(@PathVariable int id) {
        return brandService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandsListItemDto> getAll() {
        return brandService.getAll();
    }
}
