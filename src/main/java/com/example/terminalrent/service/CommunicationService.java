package com.example.terminalrent.service;

import com.example.terminalrent.dto.CommunicationPojo;
import com.example.terminalrent.entity.Communication;
import com.example.terminalrent.entity.Model;
import com.example.terminalrent.jpa.CommunicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunicationService {
    private final CommunicationRepository communicationRepository;

    public List<CommunicationPojo> findAll() {
        List<CommunicationPojo> res = new ArrayList<>();
        for (Communication communication : communicationRepository.findAll())
            res.add(CommunicationPojo.fromEntity(communication));

        return res;
    }

    public CommunicationPojo findById(long id) {
        return CommunicationPojo.fromEntity(communicationRepository.findById(id).orElseThrow());
    }

    public CommunicationPojo create (CommunicationPojo state) {
        return CommunicationPojo.fromEntity(communicationRepository.save(CommunicationPojo.toEntity(state)));
    }

    public CommunicationPojo update (CommunicationPojo pojo) {
        Communication communication = CommunicationPojo.toEntity(pojo);
        communication.setModels(communicationRepository.findById(pojo.getId()).orElseThrow().getModels());
        return CommunicationPojo.fromEntity(communicationRepository.save(communication));
    }

    public boolean delete (long id) {
        if (communicationRepository.existsById(id)) {
            for (Model model : communicationRepository.findById(id).orElseThrow().getModels())
                model.setCommunication(null);
            communicationRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
