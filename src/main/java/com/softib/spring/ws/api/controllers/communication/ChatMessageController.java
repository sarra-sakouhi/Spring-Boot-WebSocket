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

import com.softib.spring.ws.api.entities.communication.ChatMessage;
import com.softib.spring.ws.api.entities.user.Client;
import com.softib.spring.ws.api.services.communication.ChatMessageService;

@RestController
@RequestMapping("/com/")
public class ChatMessageController {
	@Autowired
	private ChatMessageService chatMessageService;

	@GetMapping("/ChatMessages")
	public List<ChatMessage> getAllChatMessages(){

		return chatMessageService.getAllChatMessages();
	}

	@PostMapping("/ChatMessages")
	public ChatMessage createChatMessage(@RequestBody ChatMessage chatMessage) {
		return chatMessageService.createChatMessage(chatMessage);
	}

	@GetMapping("/ChatMessages/{id}")
	public ResponseEntity<ChatMessage> getChatMessageById(@PathVariable long id) {

		ChatMessage chatMessage=chatMessageService.getChatMessageById(id);
		return ResponseEntity.ok(chatMessage);
	}

	@PutMapping("/ChatMessages/{id}")
	public ResponseEntity<ChatMessage> updateChatMessage(@PathVariable long id, @RequestBody ChatMessage chatMessageWithUpdates){

		ChatMessage updatedChatMessage=chatMessageService.updateChatMessage(id,chatMessageWithUpdates);
		return ResponseEntity.ok(updatedChatMessage);
	}

	@DeleteMapping("/ChatMessages/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteChatMessage(@PathVariable long id){

		chatMessageService.deleteChatMessage(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}
