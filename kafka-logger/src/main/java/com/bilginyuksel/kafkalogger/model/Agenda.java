package com.bilginyuksel.kafkalogger.model;

import java.io.Serializable;
import java.util.Date;

public class Agenda implements Serializable {
    private int id;
    private String note;
    private Date createdDate;
    private Date loggedDate;
    private User createdBy, showedBy;

}
