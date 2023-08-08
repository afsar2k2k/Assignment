package com.company.rewards.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 //CREATE TABLE PURCHASE_INFO (PUR_ID int,PSN_ID int ,PUR_DATE DATE,PUR_AMOUNT int);


@Entity
@Table(name = "PURCHASE_INFO")
public class PurchaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "PUR_ID")
    private Long purchaseId;

    @Column(name="PSN_ID")
    private Long personId;

    @Column(name = "PUR_DATE")
    private Timestamp purchaseDate;

    @Column(name = "PUR_AMOUNT")
    private Double purchaseAmount;


    public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
