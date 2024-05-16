package com.metaverso.metaverso_java.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "purchase")

public class Purchase {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100,nullable = false)
    private String city;
    @Column(nullable = false)
    private LocalDateTime purchaseDay;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id",referencedColumnName = "id")
    private User users;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_id",referencedColumnName = "id")
    private Product product;
}
