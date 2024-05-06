package com.turkcell.rentacar.inventoryService.business.rules;

import com.turkcell.rentacar.inventoryService.business.messages.BrandMessages;
import com.turkcell.rentacar.inventoryService.core.business.abstracts.MessageService;
import com.turkcell.rentacar.inventoryService.core.utilities.exception.types.BusinessException;
import com.turkcell.rentacar.inventoryService.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.inventoryService.entity.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    private MessageService messageService;

    public void brandShouldBeExist(Optional<Brand> brand) {
        if (brand.isEmpty()) {
            throw new BusinessException(messageService.getMessage(BrandMessages.BRAND_ALREADY_EXISTS));
        }
    }

    public void brandIdShouldBeExist(int brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        if (brand.isEmpty()) {
            throw new BusinessException(messageService.getMessage(BrandMessages.BRAND_NOT_FOUND));
        }
    }

    public void brandNameCanNotBeDuplicatedWhenInserted(String name) {
        Optional<Brand> foundOptionalBrand = brandRepository.findByNameIgnoreCase(name.trim());
        if (foundOptionalBrand.isPresent()) {
            throw new BusinessException(messageService.getMessage(BrandMessages.BRAND_ALREADY_EXISTS));
        }
    }

    public void brandNameCanNotBeDuplicatedWhenUpdated(int id, String name) {
        boolean exists = brandRepository.existsByNameIgnoreCaseAndIdIsNot(name.trim(), id);
        if (exists) {
            throw new BusinessException(messageService.getMessage(BrandMessages.BRAND_ALREADY_EXISTS));
        }
    }
}