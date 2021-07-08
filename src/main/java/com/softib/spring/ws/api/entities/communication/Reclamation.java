package com.softib.spring.ws.api.entities.communication;



import javax.persistence.DiscriminatorValue;

import com.softib.spring.ws.api.entities.user.Departement;

@DiscriminatorValue("RECLAMATION")
public class Reclamation extends Message {
	private Departement departement;
	private boolean resolu;
}
