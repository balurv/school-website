package com.eazybytes.eazyschool.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Data
public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FESTIVAL,
        FEDERAL
    }
}
