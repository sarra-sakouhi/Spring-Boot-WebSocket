package com.softib.spring.ws.api.services.comptebancaire;


import org.springframework.stereotype.Service;

import com.softib.spring.ws.api.entities.comptebancaire.CompteBancaire;

@Service
public interface ICompteBancaireService {

	public CompteBancaire getCompteBancaireParId(long id);

	public void updateCompteBancaire(CompteBancaire cb);

	public boolean deleteCompteBancaireById(long id);
}
