package com.turkcell.rentacar.inventoryService.business.concretes;

import com.turkcell.rentacar.common.events.InventoryCreatedEvent;
import com.turkcell.rentacar.inventoryService.business.abstracts.BrandService;
import com.turkcell.rentacar.inventoryService.business.dto.request.brands.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dto.request.brands.UpdateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.CreatedBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.GetAllBrandsListItemDto;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.GetBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dto.responses.brands.UpdatedBrandResponse;
import com.turkcell.rentacar.inventoryService.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.inventoryService.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.inventoryService.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.inventoryService.entity.concretes.Brand;
import com.turkcell.rentacar.inventoryService.kafka.producers.InventoryProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
    private InventoryProducer inventoryProducer;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicatedWhenInserted(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand = brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse = modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);
        InventoryCreatedEvent inventoryCreatedEvent = new InventoryCreatedEvent(createdBrandResponse.getId(),createdBrandResponse.getName());
        inventoryProducer.sendMessage(inventoryCreatedEvent);
        return createdBrandResponse ;

    }

    @Override
    public UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest) {
        brandBusinessRules.brandIdShouldBeExist(id);
        brandBusinessRules.brandNameCanNotBeDuplicatedWhenUpdated(id, updateBrandRequest.getName());
        Brand brandToUpdate = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandToUpdate.setId(id);
        Brand updatedBrand = brandRepository.save(brandToUpdate);
        return modelMapperService.forResponse().map(updatedBrand, UpdatedBrandResponse.class);
    }

    @Override
    public void delete(int id) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(id);
        brandRepository.delete(foundOptionalBrand.get());
    }

    @Override
    public List<GetAllBrandsListItemDto> getAll() {
        List<Brand> brands = brandRepository.findAll();
        // example of using stream api
        return brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsListItemDto.class))
                .toList();
    }

    @Override
    public GetBrandResponse get(int id) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(id);
        brandBusinessRules.brandShouldBeExist(foundOptionalBrand);
        return modelMapperService.forResponse().map(foundOptionalBrand.get(), GetBrandResponse.class);
    }
}
