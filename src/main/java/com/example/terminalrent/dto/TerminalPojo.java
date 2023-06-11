package com.example.terminalrent.dto;

import com.example.terminalrent.entity.Terminal;
import com.example.terminalrent.enums.States;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TerminalPojo {
    private long id;
    private int code;
    private long m_id;  //private ModelPojo model;
    private String m_name;
    private States state;
    private long contract_id;


    public static TerminalPojo fromEntity(Terminal terminal){
        TerminalPojo pojo = new TerminalPojo();
        pojo.setId(terminal.getId());
        pojo.setCode(terminal.getCode());
        pojo.setState(terminal.getState());

        if (terminal.getModel() != null) {
            pojo.setM_id(terminal.getModel().getId());
            pojo.setM_name(terminal.getModel().getName());
        }
        if (terminal.getContract() != null) {
            pojo.setContract_id(terminal.getContract().getId());
        }

        return pojo;
    }

    public static Terminal toEntity(TerminalPojo pojo){
        Terminal terminal = new Terminal();
        terminal.setId(pojo.getId());
        terminal.setCode(pojo.getCode());
        terminal.setState(pojo.getState());

        return terminal;
    }
}
