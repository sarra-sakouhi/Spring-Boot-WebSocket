package com.javatechie.spring.ws.api.entities.user;


import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agent extends Utilisateur {
	private Poste poste;
	private Date dateEmbauche;
	private String matricule;
	private Departement departement;

}
