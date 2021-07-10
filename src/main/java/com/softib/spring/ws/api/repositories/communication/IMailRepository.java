package com.softib.spring.ws.api.repositories.communication;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softib.spring.ws.api.entities.communication.Mail;

public interface IMailRepository extends JpaRepository<Mail, Long> {

	List<Mail> findByObjet(String object);

	List<Mail> findByDraft(boolean b);
}
