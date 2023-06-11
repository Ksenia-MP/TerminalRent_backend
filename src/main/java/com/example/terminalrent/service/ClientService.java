package com.example.terminalrent.service;

import com.example.terminalrent.dto.ClientPojo;
import com.example.terminalrent.dto.ContractPojo;
import com.example.terminalrent.entity.Client;
import com.example.terminalrent.entity.Contract;
import com.example.terminalrent.jpa.ClientRepository;
import com.example.terminalrent.jpa.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientPojo> findAll() {
        List<ClientPojo> res = new ArrayList<>();
        for (Client client : clientRepository.findAll())
            res.add(ClientPojo.fromEntity(client));

        return res;
    }

    public ClientPojo findById(long id) {
        return ClientPojo.fromEntity(clientRepository.findById(id).orElseThrow());
    }

    public ClientPojo create(ClientPojo pojo) {
        return ClientPojo.fromEntity(clientRepository.save(ClientPojo.toEntity(pojo)));
    }

    public ClientPojo update(ClientPojo pojo) {
        Client client = ClientPojo.toEntity(pojo);
        client.setContracts(clientRepository.getReferenceById(pojo.getId()).getContracts());

        return ClientPojo.fromEntity(clientRepository.save(client));
    }

    public boolean delete(long id) {
        if (clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
