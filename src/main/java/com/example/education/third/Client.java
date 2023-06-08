package com.example.education.third;

import java.util.List;
import lombok.ToString;

@ToString
public class Client {
    private int id;
    private String name;
    private int age;
    private List<Phone> phones;

    public Client(int id, String name, int age, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
