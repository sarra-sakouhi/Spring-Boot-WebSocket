package com.javatechie.spring.ws.api.entities.communication;



import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.javatechie.spring.ws.api.entities.user.Utilisateur;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPEMESSAGE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MESSAGE")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Utilisateur emetteur;
	@OneToMany
	private List<Utilisateur> utilisateursCible;
	private String message;
	private Date date;	
}
