package com.softib.spring.ws.api.services.communication;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.softib.spring.ws.api.entities.communication.Mail;
import com.softib.spring.ws.api.entities.communication.Message;
import com.softib.spring.ws.api.entities.user.Utilisateur;
import com.softib.spring.ws.api.exceptions.RessourceNotFoundException;
import com.softib.spring.ws.api.repositories.communication.IMailRepository;

@Service
public class MailService implements IMailService{
	@Autowired
	private IMailRepository mailRepository;
	
	
	@Autowired
    private JavaMailSender mailSender;
	
	
	private static final String RESSOURCE_NOT_FOUND_MSG="Mail not found with id ";

	public List<Mail> getAllMails() {

	return mailRepository.findAll();

	}

	@Override
	public Mail createMailDraft(Mail mail) {
		mail.setDraft(true);
		mail.setDate(Calendar.getInstance().getTime());
		return mailRepository.save(mail);
	}

	@Override
	public Mail updateMailDraft(long id, Mail mailWithUpdates) {
		Mail mail = mailRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));

		mail.setContent(mailWithUpdates.getContent());
		mail.setSender(mailWithUpdates.getSender());
		mail.setRecievers(mailWithUpdates.getRecievers());
		mail.setDate(Calendar.getInstance().getTime());
		mail.setObjet(mailWithUpdates.getObjet());
		Mail updatedMail = mailRepository.save(mail);
		
		return updatedMail;
	}

	@Override
	public void deleteDraft(long id) {
		Mail mail = mailRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));

				mailRepository.delete(mail);
	}
	

	@Override
	public Mail getMailById(long id) {

	return mailRepository.findById(id)
	.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));
	}
	
	
	//Mail test---------------------------------------------------------------------
	
		@Autowired
		private Environment env;
		
		public void sendMailTest() {
			String from = env.getProperty("spring.mail.username");
			String to = "ayeb.nermine@esprit.tn";
			 
			SimpleMailMessage message = new SimpleMailMessage();
			 
			message.setFrom(from);
			message.setTo(to);
			message.setSubject("sendMailTest");
			message.setText("send mail test succeeded !");
			 
			mailSender.send(message);
		}

	@Override
	public List<Mail> getAllDraftMails() {
		return mailRepository.findByDraft(true);
	}

	@Override
	public List<Mail> getMailsByObject(String object) {
		return mailRepository.findByObjet(object);
	}
	
	@Override
	public void sendMail(Mail mail) {
		
		String from = env.getProperty("spring.mail.username");
		SimpleMailMessage message = new SimpleMailMessage();
		 
		message.setFrom(from);
		message.setSubject(mail.getObjet());
		message.setText(mail.getContent());
		
		for(Utilisateur reciever: mail.getRecievers()) {
			String to = mail.getRecievers().get(0).getEmail();			
			message.setTo(to);			 
			mailSender.send(message);
		}
		
		mail.setDraft(false);
		mail.setDate(Calendar.getInstance().getTime());
		mailRepository.save(mail);
	}
}
