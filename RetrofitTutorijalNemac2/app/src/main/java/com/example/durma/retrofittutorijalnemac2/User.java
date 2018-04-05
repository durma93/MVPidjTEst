package com.example.durma.retrofittutorijalnemac2;

/**
 * Created by durma on 9.1.18..
 */

public class User {

    private Integer id;
    private String name;
    private String email;
    private int age;
    private String[] topic;

    public User(String name, String email, int age, String[] topic) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }
}
