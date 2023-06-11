package com.example.terminalrent.jpa;

import com.example.terminalrent.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findAllByClient_id(long client_id);
}
