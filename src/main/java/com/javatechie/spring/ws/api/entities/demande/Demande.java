package com.javatechie.spring.ws.api.entities.demande;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.javatechie.spring.ws.api.entities.user.Utilisateur;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Demande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Utilisateur demandeur;
	@OneToOne
	private Utilisateur traiteur;
	private Date dateDemande;
	private Date dateReponse;
	private ReponseDemande reponseDemande;

}
