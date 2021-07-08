package com.softib.spring.ws.api.repositories.communication;


import org.springframework.data.jpa.repository.JpaRepository;

import com.softib.spring.ws.api.entities.communication.Message;

public interface IMessageRepository extends JpaRepository<Message, Long> {

}
