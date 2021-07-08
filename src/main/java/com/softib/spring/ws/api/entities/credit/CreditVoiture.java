package com.softib.spring.ws.api.entities.credit;



import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.softib.spring.ws.api.entities.comptebancaire.CompteBancaire;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("VOITURE")
public class CreditVoiture extends Credit {

	private double autoFinancement;

	public double getAutoFinancement() {
		return autoFinancement;
	}

	public void setAutoFinancement(double autoFinancement) {
		this.autoFinancement = autoFinancement;
	}

	public CreditVoiture(Long id, double totalAmount, Date echanceDate, short monthDuration, double rate,
			Date creditDate, double tmm, short nbMonthsRemaining, boolean active, CompteBancaire bankAccount,
			double autoFinancement) {
		super(id, totalAmount, echanceDate, monthDuration, rate, creditDate, tmm, nbMonthsRemaining, active,
				bankAccount);
		this.autoFinancement = autoFinancement;
	}

	public CreditVoiture(Long id, double totalAmount, Date echanceDate, short monthDuration, double rate,
			Date creditDate, double tmm, short nbMonthsRemaining, boolean active, CompteBancaire bankAccount) {
		super(id, totalAmount, echanceDate, monthDuration, rate, creditDate, tmm, nbMonthsRemaining, active,
				bankAccount);
	}
	
	

}
