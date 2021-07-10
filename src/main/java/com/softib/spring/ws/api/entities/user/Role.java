package com.softib.spring.ws.api.entities.user;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

	@Id
	private Long id;
	private String titre;
	private boolean active;
	
	@ManyToOne
    @JsonBackReference
    private Utilisateur user;

}
