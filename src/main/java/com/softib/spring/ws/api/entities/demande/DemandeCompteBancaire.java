package com.softib.spring.ws.api.entities.demande;



import com.softib.spring.ws.api.entities.comptebancaire.AccountType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandeCompteBancaire extends Demande {

	private AccountType typeDeCompte;

}
