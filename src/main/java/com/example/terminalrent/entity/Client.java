package com.example.terminalrent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fio;

    @Column(name = "phone", columnDefinition = "text", length = 11)
    private String phone;

    private String company_name;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Contract> contracts;
}
