package com.marouaneLK.billing_service.entities;

import com.marouaneLK.billing_service.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double price;
    private long productId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;
    @Transient
    private Product product;
}
