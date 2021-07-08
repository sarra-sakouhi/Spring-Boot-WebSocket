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

		Message updatedMessage = messageRepository.save(message);
		return updatedMessage;
	}

	public void deleteMessage(long id) {

	Message message = messageRepository.findById(id)
	.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));

	messageRepository.delete(message);

	}
	
	//Mail
	@Autowired
    private JavaMailSender mailSender;
	
	public void sendMail(Mail mail) {
		String from = mail.getEmetteur().getEmail();
		String to = mail.getUtilisateursCible().get(0).getEmail();
		 
		SimpleMailMessage message = new SimpleMailMessage();
		 
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(mail.getObjet());
		message.setText(mail.getMessage());
		 
		mailSender.send(message);
	}
	
	
	//Mail test---------------------------------------------------------------------
	
	@Autowired
	private Environment env;
	
	public void sendMailTest() {
		String from = env.getProperty("spring.mail.username");
		String to = "achref.gomri@wooden.tn";
		 
		SimpleMailMessage message = new SimpleMailMessage();
		 
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Message from heart");
		message.setText("Love you <3.");
		 
		mailSender.send(message);
	}
}
