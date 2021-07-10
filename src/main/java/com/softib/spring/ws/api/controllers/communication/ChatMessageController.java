package com.softib.spring.ws.api.controllers.communication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softib.spring.ws.api.entities.communication.ChatMessage;
import com.softib.spring.ws.api.entities.user.Utilisateur;
import com.softib.spring.ws.api.model.ChatMessage2;
import com.softib.spring.ws.api.services.communication.ChatMessageService;

@RestController
@RequestMapping("/com/")
public class ChatMessageController {
	
	//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
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
	
	
	//web socket
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){//, @PathVariable String chaine) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	@MessageMapping("/chat.privateregister")
	@SendTo("/queue/private")
	public ChatMessage registerPrivate(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		chatMessageService.createChatMessage(chatMessage);
		return chatMessage;
	}
	
	//chatbot
	@MessageMapping("/chat.botregister")
	@SendTo("/queue/chatbot")
	public ChatMessage registerBot(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	
	@MessageMapping("/chat.botsend")
	@SendTo("/queue/chatbot")
	public ChatMessage sendBotMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@MessageMapping("/chat.botanswer")
	@SendTo("/queue/chatbot")
	public ChatMessage sendBotAnswer(@Payload ChatMessage chatMessage) {
		Utilisateur bot = new Utilisateur();
		bot.setNom("Alice");
		ChatMessage botMessage=new ChatMessage();
		botMessage.setChaine("chatbot");
		botMessage.setContent(chatMessageService.botAnswer(chatMessage.getContent()));
		botMessage.setSender(bot);
		return botMessage;
	}
	
	@MessageMapping("/chat.privatesend")
	@SendTo("/queue/private")
	public ChatMessage sendPrivateMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
}
