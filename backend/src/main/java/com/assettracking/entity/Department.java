package com.assettracking.entity;

import com.assettracking.entity.type.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="departments")
public class Department extends  BaseEntity{

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    @Column(name="department_name",unique = true, nullable = false)
    private String departmentName;

    @Column(length=255)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;

}
