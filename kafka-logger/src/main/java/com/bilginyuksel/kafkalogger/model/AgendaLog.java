package com.bilginyuksel.kafkalogger.model;

import java.util.Date;

public class AgendaLog {
    private int id;
    private String fileSlug; // Logged file name slug which is -> User00001.txt
    private Agenda agenda;
    private Date showedDate;
    private User showedUser;
}
