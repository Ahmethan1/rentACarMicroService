package com.turkcell.rentacar.searchService.api.controller;

import com.turkcell.rentacar.searchService.business.abstracts.InventoryService;
import com.turkcell.rentacar.searchService.business.dtos.FilterInventoryRequest;
import com.turkcell.rentacar.searchService.business.dtos.FilterInventoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inventoryservice/api/v1/inventory")
public class InventoriesController {
    private InventoryService inventoryService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<FilterInventoryResponse> getAll(@ModelAttribute FilterInventoryRequest inventoryRequest) {
        return inventoryService.getAll(inventoryRequest);

    }


}
