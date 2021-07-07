package com.javatechie.spring.ws.api.repositories.communication;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.ws.api.entities.communication.Message;

public interface IMessageRepository extends JpaRepository<Message, Long> {

}
