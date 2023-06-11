package com.example.terminalrent.dto;

import com.example.terminalrent.entity.Communication;
import com.example.terminalrent.entity.Model;
import com.example.terminalrent.entity.Terminal;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommunicationPojo {
    private long id;
    private String name;

    public static CommunicationPojo fromEntity(Communication communication){
        CommunicationPojo pojo = new CommunicationPojo();
        pojo.setId(communication.getId());
        pojo.setName(communication.getName());

        return pojo;
    }

    public static Communication toEntity(CommunicationPojo pojo){
        Communication communication = new Communication();
        communication.setId(pojo.getId());
        communication.setName(pojo.getName());

        List<Model> models = new ArrayList<>();
        communication.setModels(models);

        return communication;
    }
}
