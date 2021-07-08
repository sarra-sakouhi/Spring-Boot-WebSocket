package com.softib.spring.ws.api.services.communication;

import java.util.List;

import com.softib.spring.ws.api.entities.communication.ChatMessage;

public interface IChatMessageService {
	public List<ChatMessage> getAllChatMessages();

	public ChatMessage createChatMessage(ChatMessage message);

	public ChatMessage getChatMessageById(long id);

	public ChatMessage updateChatMessage(long id, ChatMessage message);

	public void deleteChatMessage(long id);
}
