package com.udacity.ConsumingRestApi.Entity;

public class Response {
    private String type;
    private Joke value;

    public Response(String type, Joke value) {
        this.type = type;
        this.value = value;
    }

    public Response(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getValue() {
        return value;
    }

    public void setValue(Joke value) {
        this.value = value;
    }
}
