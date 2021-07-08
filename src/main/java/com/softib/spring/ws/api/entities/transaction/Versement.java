package com.softib.spring.ws.api.entities.transaction;




import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VERSEMENT")
public class Versement extends Transaction {

}
