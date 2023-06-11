package com.example.terminalrent.jpa;

import com.example.terminalrent.entity.Communication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationRepository extends JpaRepository<Communication, Long> {

}
