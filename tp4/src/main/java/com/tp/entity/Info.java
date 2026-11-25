package com.tp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observation;
    private char sexe;
    private int age;

    public Info() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    public char getSexe() { return sexe; }
    public void setSexe(char sexe) { this.sexe = sexe; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}