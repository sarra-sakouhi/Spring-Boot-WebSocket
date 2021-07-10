package com.softib.spring.ws.api.entities.user;



import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.softib.spring.ws.api.entities.communication.Message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPEUSER",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
public class Utilisateur {

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
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Role> roles;
	private boolean active;

	@ManyToMany(mappedBy = "recievers", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Message> recievedMessages;
	
	//@OneToMany
    //@JsonManagedReference
	//private List<Message> recievedMessages;
}
