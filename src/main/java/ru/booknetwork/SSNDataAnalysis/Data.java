package ru.booknetwork.SSNDataAnalysis;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_name")
    private String dataName;

    @Column(name = "action")
    private String action;

    @Column(name = "data")
    private String data;

}
