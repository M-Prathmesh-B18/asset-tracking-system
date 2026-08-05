package com.assettracking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;

@Entity
@Table(
        name="roles"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name",nullable = false,unique = true,length=50)
    private String roleName;

    @Column(length=255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length=20)
    private Status status=Status.ACTIVE;


}
