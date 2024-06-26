package com.turkcell.rentacar.inventoryService.entity.concretes;

import com.turkcell.rentacar.inventoryService.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(name = "name")
    private String name;
}