package com.bilginyuksel.kafkalogger.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username, firstName, lastName, email;
    private final String fileCodecx;

    public User(){
        // Create a file codecx for every user
        fileCodecx = id+ username + "xx00xx.txt";
    }
}
