package com.sawant.employeeinformation.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="firstName", nullable = false)
    String firstName;

    @Column(name="lastName", nullable = false)
    String lastName;

    @Column(name="gender", nullable = false)
    String gender;

    @Column(name="address", nullable = false)
    String address;
}
