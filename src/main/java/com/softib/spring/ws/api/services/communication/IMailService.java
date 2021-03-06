package com.softib.spring.ws.api.services.communication;

import java.util.List;

import com.softib.spring.ws.api.entities.communication.Mail;
import com.softib.spring.ws.api.entities.user.Utilisateur;

public interface IMailService {
	
	public List<Mail> getAllMails();
		
	public List<Mail> getAllDraftMails();

	public Mail createMailDraft(Mail mail);

	public Mail updateMailDraft(long id, Mail mail);

	public void deleteDraft(long id);
	
	public Mail getMailById(long id);
	
	public List<Mail> getMailsByObject(String object);
	
	public void sendMail(Mail mail);
}
