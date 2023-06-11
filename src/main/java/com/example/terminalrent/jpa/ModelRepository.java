package com.example.terminalrent.jpa;

import com.example.terminalrent.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
