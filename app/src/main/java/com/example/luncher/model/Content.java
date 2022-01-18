package com.example.luncher.model;

public class Content {


    private int ID;
    private String name;
    private String topic;

    public Content(){ }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Content(int ID, String name, String topic) {
        this.ID = ID;
        this.name = name;
        this.topic = topic;


    }


}
