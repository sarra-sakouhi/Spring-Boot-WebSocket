package com.softib.spring.ws.api.entities.user;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Utilisateur {
	private DomaineActivite domaineActivite;
	private NatureActivite natureActivite;
}
