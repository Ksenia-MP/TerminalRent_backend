package com.example.terminalrent.entity;

import com.example.terminalrent.enums.States;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "terminals", uniqueConstraints = {@UniqueConstraint(columnNames = "code")})
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code", unique = true, nullable = false)
    private int code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Model model;

    private States state;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Contract contract;
}
