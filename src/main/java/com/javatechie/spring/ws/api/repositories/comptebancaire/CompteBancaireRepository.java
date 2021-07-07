package com.javatechie.spring.ws.api.repositories.comptebancaire;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.ws.api.entities.comptebancaire.CompteBancaire;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {

}
