package com.aravi.statusmaster.model;

public class Status {

    public String name;
    public String type;
    public Long lastUpdated;

    public Status(){

    }

    public Status(String name, String type, Long lastUpdated) {
        this.name = name;
        this.type = type;
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

