package com.example.demo.util;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Message implements Serializable {

    protected String result;

    public Message(String result) {
        this.result = result;
    }
}
