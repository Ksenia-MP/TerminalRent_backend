package com.example.terminalrent.enums;

import lombok.Getter;

@Getter
public enum States {
    NEW("N"),
    USED("U"),
    BROKEN("B");

    private String code;

    States(String code) {
        this.code = code;
    }
}
