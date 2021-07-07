package com.javatechie.spring.ws.api.repositories.user;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.ws.api.entities.user.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
