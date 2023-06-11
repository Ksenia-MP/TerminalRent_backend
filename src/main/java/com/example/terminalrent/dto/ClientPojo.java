package com.example.terminalrent.dto;

import com.example.terminalrent.entity.Client;
import com.example.terminalrent.entity.Contract;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientPojo {
    public long id;
    private String fio;
    private String phone;
    private String company_name;

    public static ClientPojo fromEntity(Client client){
        ClientPojo pojo = new ClientPojo();
        pojo.setId(client.getId());
        pojo.setFio(client.getFio());
        pojo.setPhone(client.getPhone());
        pojo.setCompany_name(client.getCompany_name());

        return pojo;
    }

    public static Client toEntity(ClientPojo pojo){
        Client client = new Client();
        client.setId(pojo.getId());
        client.setFio(pojo.getFio());
        client.setPhone(pojo.getPhone());
        client.setCompany_name(pojo.getCompany_name());

        List<Contract> contracts = new ArrayList<>();
        client.setContracts(contracts);

        return client;
    }
}
