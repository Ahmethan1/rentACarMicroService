package com.turkcell.rentacar.searchService.dataAccess.abstracts;

import com.turkcell.rentacar.searchService.entities.concretes.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    @Query("{ '$or' : [ { 'brandId' : ?0 }, { 'brandName' : ?1 } ] }")
    List<Inventory> findByBrandIdOrName(int brandId, String name);
}
