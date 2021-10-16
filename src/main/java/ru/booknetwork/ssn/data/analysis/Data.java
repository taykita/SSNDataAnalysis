package ru.booknetwork.ssn.data.analysis;

import javax.persistence.*;

@Entity
public class Data {
    public Data(String dataName, String action, String data) {
        this.dataName = dataName;
        this.action = action;
        this.data = data;
    }

    public Data() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_name")
    private String dataName;

    @Column(name = "action")
    private String action;

    @Column(name = "data")
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
