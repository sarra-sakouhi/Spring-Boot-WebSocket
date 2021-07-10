package com.softib.spring.ws.api.controllers.communication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softib.spring.ws.api.entities.communication.Mail;
import com.softib.spring.ws.api.services.communication.IMailService;
import com.softib.spring.ws.api.services.communication.MailService;

@RestController
@RequestMapping("/com/")
public class MailController {
	@Autowired
	private MailService mailService;

	@GetMapping("/Mails")
	public List<Mail> getAllMails(){

		return mailService.getAllMails();
	}
	
	@GetMapping("/DraftMails")
	public List<Mail> getAllDraftMails(){

		return mailService.getAllDraftMails();
	}

	@PostMapping("/Mails")
	public Mail createMail(@RequestBody Mail mail) {

		return mailService.createMailDraft(mail);
	}

	@GetMapping("/MailById/{id}")
	public ResponseEntity<Mail> getMailById(@PathVariable long id) {

		Mail mail=mailService.getMailById(id);
		return ResponseEntity.ok(mail);
	}
	
	@GetMapping("/MailsByObject/{object}")
	public List<Mail> getMailsByObject(@PathVariable String object) {

		return mailService.getMailsByObject(object);
		
	}

	@PutMapping("/Mails/{id}")
	public ResponseEntity<Mail> updateMail(@PathVariable long id, @RequestBody Mail mailWithUpdates){

		Mail updatedMail=mailService.updateMailDraft(id, mailWithUpdates);
		return ResponseEntity.ok(updatedMail);
	}

	@DeleteMapping("/Mails/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteMail(@PathVariable long id){

		mailService.deleteDraft(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
	
	@PostMapping("/sendMail")
	public ResponseEntity<Map<String,Boolean>> sendMailTest(@RequestBody Mail mail){
		mailService.sendMail(mail);
		Map<String,Boolean> response=new HashMap<>();
		response.put("sended", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
