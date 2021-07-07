package com.javatechie.spring.ws.api.services.communication;


import java.util.List;

import com.javatechie.spring.ws.api.entities.communication.Information;
import com.javatechie.spring.ws.api.entities.user.Agent;
import com.javatechie.spring.ws.api.entities.user.Client;

public interface IInformationService {

	public List<Information> getAllPostedInformations();

	public List<Information> getAllDraftInformations();

	public List<Information> getAllPostedInformationsByAgent(Agent agent);

	public List<Information> getAllPostedInformationsByClient(Client client);

	public Information getInformationById(long id);

	public Information createDraftInformation(Information information);

	public Information updateDraftInformation(long id, Information information);

	public void deleteDraftInformation(long id);

	public void postInformation(Information information);
}
