package com.BitGeekspracticeday3._BitGeekspracticeDay3.models;


import jakarta.persistence.*;

@Entity
@Table(name = "userDatab")
public class Studentmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "addess" , nullable = false)
    private String addess;

    @Column(name = "phone" , nullable = false)
    private String phone;

    public Studentmodel() {}

    public Studentmodel( String name, String email, String addess, String phone) {
        this.name = name;
        this.email = email;
        this.addess = addess;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
