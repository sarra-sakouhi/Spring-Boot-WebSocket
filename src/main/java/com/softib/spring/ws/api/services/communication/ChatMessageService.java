package com.softib.spring.ws.api.services.communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softib.spring.ws.api.entities.communication.ChatMessage;
import com.softib.spring.ws.api.exceptions.RessourceNotFoundException;
import com.softib.spring.ws.api.repositories.communication.IChatMessageRepository;

@Service
public class ChatMessageService implements IChatMessageService {
	
	@Autowired
	private IChatMessageRepository chatMessageRepository;
	
	private static final String RESSOURCE_NOT_FOUND_MSG="ChatMessage not found with id ";

	public List<ChatMessage> getAllChatMessages() {

	return chatMessageRepository.findAll();

	}

	public ChatMessage createChatMessage(ChatMessage chatMessage) {

	return chatMessageRepository.save(chatMessage);

	}

	public ChatMessage getChatMessageById(long id) {

	return chatMessageRepository.findById(id)
	.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));
	}

	public ChatMessage updateChatMessage(long id, ChatMessage chatMessageWithUpdates) {

		ChatMessage chatMessage = chatMessageRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));

		ChatMessage updatedChatMessage = chatMessageRepository.save(chatMessage);
		return updatedChatMessage;
	}

	public void deleteChatMessage(long id) {

	ChatMessage chatMessage = chatMessageRepository.findById(id)
	.orElseThrow(() -> new RessourceNotFoundException(RESSOURCE_NOT_FOUND_MSG + id));

	chatMessageRepository.delete(chatMessage);

	}
}
