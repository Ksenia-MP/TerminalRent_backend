package com.example.terminalrent.service;

import com.example.terminalrent.dto.ModelPojo;
import com.example.terminalrent.entity.Model;
import com.example.terminalrent.entity.Terminal;
import com.example.terminalrent.jpa.CommunicationRepository;
import com.example.terminalrent.jpa.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    private final CommunicationRepository communicationRepository;

    public List<ModelPojo> findAll() {
        List<ModelPojo> res = new ArrayList<>();
        for (Model model : modelRepository.findAll())
            res.add(ModelPojo.fromEntity(model));

        return res;
    }

    public ModelPojo findById(long id) {
        return ModelPojo.fromEntity(modelRepository.findById(id).orElseThrow());
    }

    public ModelPojo create(ModelPojo pojo) {
        Model model = ModelPojo.toEntity(pojo);
        model.setCommunication(communicationRepository.findById(pojo.getCommunication_id()).orElseThrow());

        return ModelPojo.fromEntity(modelRepository.save(model));
    }

    public ModelPojo update(ModelPojo pojo) {
        Model model = ModelPojo.toEntity(pojo);
        model.setCommunication(communicationRepository.findById(pojo.getCommunication_id()).orElseThrow());

        model.setTerminals(modelRepository.findById(pojo.getId()).orElseThrow().getTerminals());
        return ModelPojo.fromEntity(modelRepository.save(model));
    }

    public boolean delete(long id) {
        if (modelRepository.existsById(id)){
            for (Terminal terminal : modelRepository.findById(id).orElseThrow().getTerminals())
                terminal.setModel(null);
            modelRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
