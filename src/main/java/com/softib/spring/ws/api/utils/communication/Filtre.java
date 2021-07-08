package com.softib.spring.ws.api.utils.communication;



import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filtre {

	/*
	 objet qui contient nom de champs de user + opertaeur+ liste des valeurs
	exemple : domaneActivite, "=", {FINANCE,IT}
	          natureActivite, "!=", {SALARIE}
	          */
	
	private Champs champs;
	private Operateur oper;
	private List<Object> valeurs;
	
	public enum Operateur {

	}

	public enum Champs {

	}
}

