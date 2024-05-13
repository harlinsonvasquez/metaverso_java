package com.metaverso.metaverso_java.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="suscriptionproduct")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuscriptionProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producto_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="suscription_id", referencedColumnName = "id")
    private Suscription suscription;
}
