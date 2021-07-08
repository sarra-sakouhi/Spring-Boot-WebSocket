package com.softib.spring.ws.api.services.transaction.virement;

import com.softib.spring.ws.api.entities.comptebancaire.CompteBancaire;

public interface IVirementService {

	public void doVirementByCompte(CompteBancaire source, CompteBancaire distination, double montant);

	public void saveVirement(CompteBancaire source, CompteBancaire distination, double montant,
			String libeleTransaction);
}
