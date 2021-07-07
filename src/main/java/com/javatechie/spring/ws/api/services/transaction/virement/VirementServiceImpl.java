package com.javatechie.spring.ws.api.services.transaction.virement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;
import com.javatechie.spring.ws.api.entities.transaction.Transaction;
import com.javatechie.spring.ws.api.entities.transaction.Virement;
import com.javatechie.spring.ws.api.services.comptebancaire.CompteBancaireServiceImpl;
import com.javatechie.spring.ws.api.services.transaction.TransactionServiceImpl;
import com.javatechie.spring.ws.api.utils.comptebancaire.CompteBancaireUtils;

@Transactional
@Service
public class VirementServiceImpl implements IVirementService {
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	@Autowired
	CompteBancaireServiceImpl compteBancaireServiceImpl;

	public List<Transaction> getListVirementByCompteAndType(CompteBancaire compteBancaire) {
		return transactionServiceImpl.findTransactionByCompteBancaireAndTransactionType(compteBancaire, "VIREMENT");
	}

	@Override
	public void doVirementByCompte(CompteBancaire source, CompteBancaire distination, double montant) {
		if (CompteBancaireUtils.checkSoldeDisponible(source, montant)) {
			source.setSolde(source.getSolde() - montant);
			distination.setSolde(distination.getSolde() + montant);
			compteBancaireServiceImpl.updateCompteBancaire(source);
			compteBancaireServiceImpl.updateCompteBancaire(distination);
		}
	}

	@Override
	public void saveVirement(CompteBancaire source, CompteBancaire distination, double montant,
			String libeleTransaction) {
		Transaction virement = new Virement();
		virement.setMontant(montant);
		virement.setCompteSource(source);
		virement.setLibeleTransaction(libeleTransaction);
		virement.setDate(new Date());
		transactionServiceImpl.saveTransaction(virement);
	}

}
