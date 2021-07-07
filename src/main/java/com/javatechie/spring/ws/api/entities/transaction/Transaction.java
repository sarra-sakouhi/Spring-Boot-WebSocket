package com.javatechie.spring.ws.api.entities.transaction;



import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPETRANSACTION")
@Getter
@Setter
public abstract class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private CompteBancaire compteSource;
	private double montant;
	private String libeleTransaction;
	private long numeroTransaction;
	@NonNull
	private Date date;

}
