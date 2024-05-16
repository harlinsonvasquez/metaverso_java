package com.metaverso.metaverso_java.domain.entities;

import java.util.List;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity (name = "users")
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
    private String lastName;
    private String email;
    private String city;
    @Column (length = 100, nullable = false)
    private String password;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "users",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )    
    private List<Purchase> purchases;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "Suscription_id",referencedColumnName = "id")
    private Subscription subscription;
}
