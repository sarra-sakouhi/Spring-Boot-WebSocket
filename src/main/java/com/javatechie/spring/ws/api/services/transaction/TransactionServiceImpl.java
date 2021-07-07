package com.javatechie.spring.ws.api.services.transaction;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;
import com.javatechie.spring.ws.api.entities.transaction.Transaction;
import com.javatechie.spring.ws.api.repositories.transaction.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getTransactionsByCompte(CompteBancaire compte) {
		return transactionRepository.findByCompteSource(compte);
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findTransactionByCompteBancaireAndTransactionType(CompteBancaire compteBancaire,
			String typeTransaction) {
		return transactionRepository.findTransactionByCompteBancaireAndTransactionType(compteBancaire, typeTransaction);
	}

}
