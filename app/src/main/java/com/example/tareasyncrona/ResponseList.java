package com.example.tareasyncrona;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseList<T> {

    @SerializedName("data")
    private ArrayList<T> data;
    @SerializedName("message")
    private String message;

    public ResponseList(){

    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
