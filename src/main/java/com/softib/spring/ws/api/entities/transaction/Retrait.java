package com.softib.spring.ws.api.entities.transaction;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RETRAIT")
public class Retrait extends Transaction {

}
