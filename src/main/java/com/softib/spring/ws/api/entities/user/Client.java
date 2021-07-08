package com.softib.spring.ws.api.entities.user;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Utilisateur {
	private DomaineActivite domaineActivite;
	private NatureActivite natureActivite;
}
