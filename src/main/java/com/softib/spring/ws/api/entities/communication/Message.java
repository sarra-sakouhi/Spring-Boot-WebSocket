package com.softib.spring.ws.api.entities.communication;



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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.softib.spring.ws.api.entities.user.Utilisateur;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPEMESSAGE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MESSAGE")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Utilisateur sender;
	
	private String content;
	private Date date;
	
	@ManyToMany
    private List<Utilisateur> recievers;

	public Message(Long id, Utilisateur sender, String message, Date date, List<Utilisateur> recievers) {
		this.id = id;
		this.sender = sender;
		this.content = message;
		this.date = date;
		this.recievers = recievers;
	}
	
}
