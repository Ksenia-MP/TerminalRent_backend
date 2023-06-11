package com.example.terminalrent.dto;

import com.example.terminalrent.entity.Contract;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContractPojo {
    private long id;
    private int code;
    private String address;
    private Date start;
    private Date finish;
    private long cl_id;
    private long t_id;

    private String cl_fio;
    private int t_code;

    public static ContractPojo fromEntity(Contract contract){
        ContractPojo pojo = new ContractPojo();
        pojo.setId(contract.getId());
        pojo.setCode(contract.getCode());
        pojo.setAddress(contract.getAddress());
        pojo.setStart(contract.getStart());
        pojo.setFinish(contract.getFinish());
        pojo.setCl_id(contract.getClient().getId());
        pojo.setCl_fio(contract.getClient().getFio());
        pojo.setT_code(contract.getTerminal().getCode());

        return pojo;
    }

    public static Contract toEntity(ContractPojo pojo){
        Contract contract = new Contract();
        contract.setId(pojo.getId());
        contract.setCode(pojo.getCode());
        contract.setAddress(pojo.getAddress());
        contract.setStart(pojo.getStart());
        contract.setFinish(pojo.getFinish());

        return contract;
    }
}
