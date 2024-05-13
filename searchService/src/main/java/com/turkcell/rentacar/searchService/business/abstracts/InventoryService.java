package com.turkcell.rentacar.searchService.business.abstracts;

import com.turkcell.rentacar.searchService.business.dtos.FilterInventoryRequest;
import com.turkcell.rentacar.searchService.business.dtos.FilterInventoryResponse;
import com.turkcell.rentacar.searchService.entities.concretes.Inventory;

import java.util.List;

public interface InventoryService {
    void add(Inventory inventory);
    List<FilterInventoryResponse> getAll(FilterInventoryRequest filterInventoryRequest);
}
