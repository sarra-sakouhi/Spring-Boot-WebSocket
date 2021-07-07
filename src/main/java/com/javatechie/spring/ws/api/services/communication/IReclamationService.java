package com.javatechie.spring.ws.api.services.communication;

import java.util.List;

import com.javatechie.spring.ws.api.entities.communication.Reclamation;

public interface IReclamationService {
	public List<Reclamation> getAllReclamations();

	public Reclamation createReclamation(Reclamation reclamation);

	public Reclamation getReclamationById(long id);

	public Reclamation updateReclamation(long id, Reclamation reclamation);

	public void deleteReclamation(long id);
}
