package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseClass implements Serializable {
    private String a;
    private String b;
    private String c;
}
