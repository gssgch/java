package com.myjava.io.aaa.demo1;

import java.io.Serializable;

public class Grade implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade() {
        super();
    }

    public Grade(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}
