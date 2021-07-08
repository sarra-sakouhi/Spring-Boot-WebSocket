package com.softib.spring.ws.api.services.comptebancaire;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softib.spring.ws.api.entities.comptebancaire.CompteBancaire;
import com.softib.spring.ws.api.repositories.comptebancaire.CompteBancaireRepository;

@Service
public class CompteBancaireServiceImpl implements ICompteBancaireService {

	@Autowired
	private CompteBancaireRepository compteBancaireRepository;

	@Override
	public CompteBancaire getCompteBancaireParId(long id) {
		return compteBancaireRepository.getById(id);
	}

	@Override
	public void updateCompteBancaire(CompteBancaire cb) {
		compteBancaireRepository.save(cb);
	}

	public void createCompteBancaire(CompteBancaire cb) {
		updateCompteBancaire(cb);
	}

	@Override
	public boolean deleteCompteBancaireById(long id) {
		compteBancaireRepository.deleteById(id);
		return true;
	}

}
