package com.example.terminalrent.jpa;

import com.example.terminalrent.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepository extends JpaRepository<Terminal, Long> {

}
