package com.example.carCRUD.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="companies")
public class CarCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    public CarCompany(String name) {
        this.name = name;
    }

    public CarCompany() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
