package com.sawant.employeeinformation.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "employee", schema = "public")
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

    @Column(name="dob", nullable = false)
    Date dob;
}
