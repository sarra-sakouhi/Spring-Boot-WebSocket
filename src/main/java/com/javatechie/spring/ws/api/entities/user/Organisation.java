package com.javatechie.spring.ws.api.entities.user;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organisation extends Client {

	private String matriculeFiscal;
	private double chiffreAffaire;
	private String registreDeCommerce;

}
