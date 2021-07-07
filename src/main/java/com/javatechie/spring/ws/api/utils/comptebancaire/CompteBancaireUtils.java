package com.javatechie.spring.ws.api.utils.comptebancaire;



import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;

public class CompteBancaireUtils {
	private CompteBancaireUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean checkSoldeDisponible(CompteBancaire source, double montant) {
		return source.getSolde() >= montant;
	}

}
