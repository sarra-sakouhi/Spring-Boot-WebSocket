package com.javatechie.spring.ws.api.entities.communication;



import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.javatechie.spring.ws.api.entities.user.Utilisateur;

import lombok.Getter;
import lombok.Setter;

@DiscriminatorValue("CHAT")
public class ChatMessage extends Message{
	private boolean vu;
	private MessageType type;
	private String sender;
	
	
	public boolean isVu() {
		return vu;
	}


	public void setVu(boolean vu) {
		this.vu = vu;
	}


	public MessageType getType() {
		return type;
	}


	public void setType(MessageType type) {
		this.type = type;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public enum MessageType {
        CHAT, JOIN, LEAVE
    }

}
