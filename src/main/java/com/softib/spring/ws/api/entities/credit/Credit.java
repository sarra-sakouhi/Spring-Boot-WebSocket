package com.softib.spring.ws.api.entities.credit;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.softib.spring.ws.api.entities.comptebancaire.CompteBancaire;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPECREDIT",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CREDIT")
public class Credit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double totalAmount;
	private Date echanceDate;
	private short monthDuration;
	private double rate;
	private Date creditDate;
	private double tmm;
	private short nbMonthsRemaining;
	private boolean active;
	@OneToOne
	private CompteBancaire bankAccount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getEchanceDate() {
		return echanceDate;
	}
	public void setEchanceDate(Date echanceDate) {
		this.echanceDate = echanceDate;
	}
	public short getMonthDuration() {
		return monthDuration;
	}
	public void setMonthDuration(short monthDuration) {
		this.monthDuration = monthDuration;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getCreditDate() {
		return creditDate;
	}
	public void setCreditDate(Date creditDate) {
		this.creditDate = creditDate;
	}
	public double getTmm() {
		return tmm;
	}
	public void setTmm(double tmm) {
		this.tmm = tmm;
	}
	public short getNbMonthsRemaining() {
		return nbMonthsRemaining;
	}
	public void setNbMonthsRemaining(short nbMonthsRemaining) {
		this.nbMonthsRemaining = nbMonthsRemaining;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public CompteBancaire getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(CompteBancaire bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Credit(Long id, double totalAmount, Date echanceDate, short monthDuration, double rate, Date creditDate,
			double tmm, short nbMonthsRemaining, boolean active, CompteBancaire bankAccount) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		this.echanceDate = echanceDate;
		this.monthDuration = monthDuration;
		this.rate = rate;
		this.creditDate = creditDate;
		this.tmm = tmm;
		this.nbMonthsRemaining = nbMonthsRemaining;
		this.active = active;
		this.bankAccount = bankAccount;
	}
	public Credit() {
		super();
	}

}
