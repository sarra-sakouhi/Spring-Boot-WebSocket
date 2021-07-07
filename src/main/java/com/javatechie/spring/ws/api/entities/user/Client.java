package com.javatechie.spring.ws.api.entities.user;


import javax.persistence.Entity;

@Entity
public abstract class Client extends Utilisateur {
	private DomaineActivite domaineActivite;
	private NatureActivite natureActivite;
}
