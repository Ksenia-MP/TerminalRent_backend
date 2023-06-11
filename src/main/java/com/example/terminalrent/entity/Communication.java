package com.example.terminalrent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "communication", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "communication", fetch = FetchType.LAZY)
    private List<Model> models;
}
