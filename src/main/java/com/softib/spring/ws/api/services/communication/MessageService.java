package com.softib.spring.ws.api.services.communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.softib.spring.ws.api.entities.communication.Mail;
import com.softib.spring.ws.api.entities.communication.Message;
import com.softib.spring.ws.api.exceptions.RessourceNotFoundException;
import com.softib.spring.ws.api.repositories.communication.IMessageRepository;

@Service
public class MessageService implements IMessageService{
	@Autowired
	private IMessageRepository messageRepository;
	
	private static final String RESSOURCE_NOT_FOUND_MSG="Message not found with id ";

	public List<Message> getAllMessages() {

	return messageRepository.findAll();

	}

	public Message createMessage(Message message) {

	return messageRepository.save(message);

	}

	public Message getMessageById(long id) {

	return messageRepository.findById(id)
	.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));
	}

	public Message updateMessage(long id, Message messageWithUpdates) {

		Message message = messageRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));

		message.setContent(messageWithUpdates.getContent());
		message.setSender(messageWithUpdates.getSender());
		message.setRecievers(messageWithUpdates.getRecievers());
		message.setDate(messageWithUpdates.getDate());
		
		Message updatedMessage = messageRepository.save(message);
		return updatedMessage;
	}

	public void deleteMessage(long id) {

	Message message = messageRepository.findById(id)
	.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));

	messageRepository.delete(message);

	}
	
	
	
}
