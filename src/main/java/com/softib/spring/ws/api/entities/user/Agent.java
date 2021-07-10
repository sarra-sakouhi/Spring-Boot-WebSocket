package com.softib.spring.ws.api.entities.user;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@DiscriminatorValue("AGENT")
public class Agent extends Utilisateur {
	private Poste poste;
	private Date dateEmbauche;
	private String matricule;
	private Departement departement;

}
