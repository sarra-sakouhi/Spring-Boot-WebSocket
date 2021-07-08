package com.softib.spring.ws.api.services.credit;


import java.util.List;

import com.softib.spring.ws.api.entities.credit.Credit;

public interface IcreditService {
	
	public List<Credit> getAllCredits();

	public Credit createCredit(Credit credit);

	public Credit getCreditById(long id);

	public Credit updateCredit(long id, Credit Credit);

	public void deleteCredit(long id);

}
