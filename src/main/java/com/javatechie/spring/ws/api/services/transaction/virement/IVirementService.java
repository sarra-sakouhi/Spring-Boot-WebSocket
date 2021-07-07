package com.javatechie.spring.ws.api.services.transaction.virement;

import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;

public interface IVirementService {

	public void doVirementByCompte(CompteBancaire source, CompteBancaire distination, double montant);

	public void saveVirement(CompteBancaire source, CompteBancaire distination, double montant,
			String libeleTransaction);
}
