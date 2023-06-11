package com.example.terminalrent.service;


import com.example.terminalrent.dto.*;
import com.example.terminalrent.entity.Contract;
import com.example.terminalrent.entity.Terminal;
import com.example.terminalrent.jpa.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final ModelRepository modelRepository;
    private final ContractRepository contractRepository;

    public List<TerminalPojo> findAll() {
        List<TerminalPojo> res = new ArrayList<>();
        for (Terminal terminal : terminalRepository.findAll())
            res.add(TerminalPojo.fromEntity(terminal));

        return res;
    }

    public TerminalPojo findById(long id) { return TerminalPojo.fromEntity(terminalRepository.findById(id).orElseThrow()); }

    public TerminalPojo create(TerminalPojo pojo) {
        Terminal terminal = TerminalPojo.toEntity(pojo);
        terminal.setModel(modelRepository.findById(pojo.getM_id()).orElseThrow());

        return TerminalPojo.fromEntity(terminalRepository.save(terminal));
    }

    public TerminalPojo update(TerminalPojo pojo) {
        Terminal terminal = TerminalPojo.toEntity(pojo);
        terminal.setModel(modelRepository.findById(pojo.getM_id()).orElseThrow());
        terminal.setContract(terminalRepository.findById(pojo.getId()).orElseThrow().getContract());

        return TerminalPojo.fromEntity(terminalRepository.save(terminal));
    }

    public boolean delete(long id) {
        if (terminalRepository.existsById(id)){
            terminalRepository.deleteById(id);
            return true;
        }

        return false;
    }

    //возвращает список терминалов с указанным id модели
    public List<TerminalPojo> findByModel (long mdl_id) {
        List<TerminalPojo> res = new ArrayList<>();
        for (Terminal terminal : modelRepository.findById(mdl_id).orElseThrow().getTerminals())
            res.add(TerminalPojo.fromEntity(terminal));

        return res;
    }

}
