package com.java.test.StringTest;


/**
 * @author shadow
 * @create 2024-09-01 15:13
 **/
public class Anaimal implements Magic {

    private String id;

    protected String name;

    public String getId() {
        return id;
    }
    public void setId(String id) {this.id=id;}
    protected native String getName();

    @Override
    public void fly() {

    }
}
