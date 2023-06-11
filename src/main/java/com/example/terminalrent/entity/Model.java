package com.example.terminalrent.entity;

import com.example.terminalrent.enums.Connection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "models", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code"),
        @UniqueConstraint(columnNames = "name")
})
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code", unique = true, nullable = false)
    private int code;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private Connection connection_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "communication_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Communication communication;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<Terminal> terminals;
}
