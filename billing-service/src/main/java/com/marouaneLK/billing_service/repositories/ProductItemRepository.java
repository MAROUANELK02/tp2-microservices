package com.marouaneLK.billing_service.repositories;

import com.marouaneLK.billing_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    Collection<ProductItem> findAllById(Long id);
}
