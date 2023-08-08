package com.company.rewards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//CREATE TABLE PERSON (PSN_ID int, PSN_NAME VARCHAR2(100) );

@Entity
@Table(name = "PERSON")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PSN_ID")
    private Long personId;
    @Column(name = "PSN_NAME")
    private String personName;

}
