package com.example.terminalrent.enums;

import lombok.Getter;

@Getter
public enum Connection {
    WIRE("W"), WIRELESS("WL"), BOTH("B");

    private String code;

    Connection(String code) {
        this.code = code;
    }

}
