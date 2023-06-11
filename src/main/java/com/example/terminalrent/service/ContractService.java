package com.example.terminalrent.service;

import com.example.terminalrent.dto.ContractPojo;
import com.example.terminalrent.entity.Contract;
import com.example.terminalrent.jpa.ClientRepository;
import com.example.terminalrent.jpa.ContractRepository;
import com.example.terminalrent.jpa.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final TerminalRepository terminalRepository;
    private final ClientRepository clientRepository;

    public List<ContractPojo> findAll() {
        List<ContractPojo> res = new ArrayList<>();
        for (Contract contract : contractRepository.findAll())
            res.add(ContractPojo.fromEntity(contract));

        return res;
    }

    public List<ContractPojo> findByClient(long cl_id) {
        List<ContractPojo> res = new ArrayList<>();
        for (Contract contract : contractRepository.findAll())
            res.add(ContractPojo.fromEntity(contract));

        return res;
    }

    public ContractPojo findById(long id) {
        return ContractPojo.fromEntity(contractRepository.findById(id).orElseThrow());
    }

    public ContractPojo create(ContractPojo pojo) {
        Contract contract = ContractPojo.toEntity(pojo);
        if (clientRepository.existsById(pojo.getCl_id()) && terminalRepository.existsById(pojo.getT_id())){
            contract.setClient(clientRepository.findById(pojo.getCl_id()).orElseThrow());
            terminalRepository.getReferenceById(pojo.getT_id()).setContract(contract);
        }
        return ContractPojo.fromEntity(contractRepository.save(contract));
    }

    public ContractPojo update(ContractPojo pojo) {
        Contract contract = ContractPojo.toEntity(pojo);
        contract.setClient(clientRepository.findById(pojo.getCl_id()).orElseThrow());
        terminalRepository.getReferenceById(pojo.getT_id()).setContract(contract);
        return ContractPojo.fromEntity(contractRepository.save(contract));
    }

    public boolean delete(long id) {
        if (contractRepository.existsById(id)) {
            contractRepository.getReferenceById(id).getTerminal().setContract(null);
            contractRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
