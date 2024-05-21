package com.metaverso.metaverso_java.domain.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity (name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 100, nullable = false)
    private String name;
    @Column (length = 100, nullable = false)
    @NotBlank(message = "el apellido es requerido")
    private String lastName;
    @NotBlank(message = "el email es obligatorio")
    private String email;
    @NotBlank(message = "la ciudad es requerida")
    private String city;
    @Column (length = 100, nullable = false)
    private String password;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )    
    private Set<Purchase> purchases;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id",referencedColumnName = "id")
    private Subscription subscription;
}
