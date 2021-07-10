package com.softib.spring.ws.api.entities.communication;


import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.softib.spring.ws.api.entities.user.Utilisateur;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("MAIL")
public class Mail extends Message {
	private String objet;
	private boolean draft;
	
	public Mail(Long id, Utilisateur sender, String message, Date date, List<Utilisateur> recievers, String objet,
			boolean draft) {
		super(id, sender, message, date, recievers);
		this.objet = objet;
		this.draft = draft;
	}
	
	
	
}
