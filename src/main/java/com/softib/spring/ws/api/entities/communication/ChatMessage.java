package com.softib.spring.ws.api.entities.communication;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("CHAT")
public class ChatMessage extends Message{
	private boolean vu;
	private MessageType type;
	private String chaine;


	public enum MessageType {
        CHAT, JOIN, LEAVE
    }

}
