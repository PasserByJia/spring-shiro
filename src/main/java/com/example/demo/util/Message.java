package com.example.demo.util;

import java.io.Serializable;

public class Message implements Serializable {

    protected String result;

    public Message(String result) {
        this.result = result;
    }
}
