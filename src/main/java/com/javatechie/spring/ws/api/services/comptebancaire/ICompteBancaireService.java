package com.javatechie.spring.ws.api.services.comptebancaire;


import org.springframework.stereotype.Service;

import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;

@Service
public interface ICompteBancaireService {

	public CompteBancaire getCompteBancaireParId(long id);

	public void updateCompteBancaire(CompteBancaire cb);

	public boolean deleteCompteBancaireById(long id);
}
