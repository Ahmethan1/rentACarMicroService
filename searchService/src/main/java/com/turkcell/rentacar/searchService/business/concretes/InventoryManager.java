package com.turkcell.rentacar.searchService.business.concretes;

import com.turkcell.rentacar.searchService.business.abstracts.InventoryService;
import com.turkcell.rentacar.searchService.business.dtos.FilterInventoryRequest;
import com.turkcell.rentacar.searchService.business.dtos.FilterInventoryResponse;
import com.turkcell.rentacar.searchService.core.utilities.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.searchService.dataAccess.abstracts.InventoryRepository;
import com.turkcell.rentacar.searchService.entities.concretes.Inventory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class InventoryManager implements InventoryService {
    private InventoryRepository inventoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void add(Inventory inventory) {
        this.inventoryRepository.save(inventory);
    }

    @Override
    public List<FilterInventoryResponse> getAll(FilterInventoryRequest filterInventoryRequest) {
        List<Inventory> inventories = this.inventoryRepository.findByBrandIdOrName(filterInventoryRequest.getBrandId(), filterInventoryRequest.getBrandName());
        this.modelMapperService.forRequest().map(filterInventoryRequest, Inventory.class);

        return inventories.stream()
                .map(inventory -> this.modelMapperService.forResponse()
                        .map(inventory, FilterInventoryResponse.class))
                .toList();
    }
}
