package com.turkcell.rentacar.inventoryService.business.abstracts;

import com.turkcell.rentacar.inventoryService.business.dto.request.brands.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dto.request.brands.UpdateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.CreatedBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.GetAllBrandsListItemDto;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.GetBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.UpdatedBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest );
    UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    List<GetAllBrandsListItemDto> getAll();
    GetBrandResponse get(int id);


}

