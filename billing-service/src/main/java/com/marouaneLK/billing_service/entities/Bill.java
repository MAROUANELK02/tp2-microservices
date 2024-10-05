package com.marouaneLK.billing_service.entities;

import com.marouaneLK.billing_service.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date bill_date;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    private long customerId;
    @Transient
    private Customer customer;
}
