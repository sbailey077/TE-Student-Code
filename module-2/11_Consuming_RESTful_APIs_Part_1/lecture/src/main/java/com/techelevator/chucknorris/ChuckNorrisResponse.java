package com.techelevator.chucknorris;

public class ChuckNorrisResponse {

    private String type;
    private ResponseValue value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResponseValue getValue() {
        return value;
    }

    public void setValue(ResponseValue value) {
        this.value = value;
    }

}
