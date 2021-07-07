package com.javatechie.spring.ws.api.entities.user;



import javax.persistence.Entity;
import javax.persistence.Id;

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

}
