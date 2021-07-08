package com.softib.spring.ws.api.entities.credit;



import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.softib.spring.ws.api.entities.comptebancaire.CompteBancaire;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {

	private double apportPersonnel;

	public double getApportPersonnel() {
		return apportPersonnel;
	}

	public void setApportPersonnel(double apportPersonnel) {
		this.apportPersonnel = apportPersonnel;
	}

	public CreditImmobilier(Long id, double totalAmount, Date echanceDate, short monthDuration, double rate,
			Date creditDate, double tmm, short nbMonthsRemaining, boolean active, CompteBancaire bankAccount,
			double apportPersonnel) {
		super(id, totalAmount, echanceDate, monthDuration, rate, creditDate, tmm, nbMonthsRemaining, active,
				bankAccount);
		this.apportPersonnel = apportPersonnel;
	}

	public CreditImmobilier(Long id, double totalAmount, Date echanceDate, short monthDuration, double rate,
			Date creditDate, double tmm, short nbMonthsRemaining, boolean active, CompteBancaire bankAccount) {
		super(id, totalAmount, echanceDate, monthDuration, rate, creditDate, tmm, nbMonthsRemaining, active,
				bankAccount);
	}
	
	

}
