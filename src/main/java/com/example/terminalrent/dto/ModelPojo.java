package com.example.terminalrent.dto;

import com.example.terminalrent.entity.Model;
import com.example.terminalrent.entity.Terminal;
import com.example.terminalrent.enums.Connection;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ModelPojo {
    private long id;
    private int code;
    private String name;
    private Connection connection_type;
    private long communication_id;
    private String comm_name;

    public static ModelPojo fromEntity(Model model){
        ModelPojo pojo = new ModelPojo();
        pojo.setId(model.getId());
        pojo.setCode(model.getCode());
        pojo.setName(model.getName());
        pojo.setConnection_type(model.getConnection_type());
        pojo.setCommunication_id(model.getCommunication().getId());
        pojo.setComm_name(model.getCommunication().getName());

        return pojo;
    }

    public static Model toEntity(ModelPojo pojo){
        Model model = new Model();
        model.setId(pojo.getId());
        model.setCode(pojo.getCode());
        model.setName(pojo.getName());
        model.setConnection_type(pojo.getConnection_type());

        List<Terminal> terminals = new ArrayList<>();
        model.setTerminals(terminals);

        return model;
    }
}
