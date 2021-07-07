package com.javatechie.spring.ws.api.entities.user;



import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String email;
	private long numTel;
	private String adress;
	private Sexe sexe;
	private Date dateNaissance;
	private String username;
	private String password;
	@OneToMany
	private List<Role> roles;
	private boolean active;

}
