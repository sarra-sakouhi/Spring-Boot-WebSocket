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

import com.softib.spring.ws.api.entities.communication.Message;
import com.softib.spring.ws.api.services.communication.IMessageService;
import com.softib.spring.ws.api.services.communication.MessageService;

@RestController
@RequestMapping("/com/")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@GetMapping("/Messages")
	public List<Message> getAllMessages(){

		return messageService.getAllMessages();
	}

	@PostMapping("/Messages")
	public Message createMessage(@RequestBody Message message) {

		return messageService.createMessage(message);
	}

	@GetMapping("/Messages/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable long id) {

		Message message=messageService.getMessageById(id);
		return ResponseEntity.ok(message);
	}

	@PutMapping("/Messages/{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable long id, @RequestBody Message messageWithUpdates){

		Message updatedMessage=messageService.updateMessage(id,messageWithUpdates);
		return ResponseEntity.ok(updatedMessage);
	}

	@DeleteMapping("/Messages/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteMessage(@PathVariable long id){

		messageService.deleteMessage(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
	
	//Mail
	@GetMapping("/sendMailTest")
	public void sendMailTest(){
		messageService.sendMailTest();
		System.out.printf("Mail Test envoyé !");
	}
}
