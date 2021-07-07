package com.javatechie.spring.ws.api.services.transaction;



import java.util.List;

import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;
import com.javatechie.spring.ws.api.entities.transaction.Transaction;

public interface ITransactionService {

	public List<Transaction> findTransactionByCompteBancaireAndTransactionType(CompteBancaire compteBancaire,
			String typeTransaction);

	public List<Transaction> getTransactionsByCompte(CompteBancaire compte);

	public void saveTransaction(Transaction transaction);
}
