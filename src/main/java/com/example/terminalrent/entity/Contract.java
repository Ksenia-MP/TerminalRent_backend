package com.example.terminalrent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "contracts", uniqueConstraints = {@UniqueConstraint(columnNames = "code") })
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code", nullable = false, unique = true)
    private int code;

    private String address;

    @Temporal(value = TemporalType.DATE)
    private Date start;

    @Temporal(value = TemporalType.DATE)
    private Date finish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Client client;

    @OneToOne(mappedBy = "contract", fetch = FetchType.LAZY)
    private Terminal terminal;
}
