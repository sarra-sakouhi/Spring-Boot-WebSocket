package com.softib.spring.ws.api.repositories.credit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softib.spring.ws.api.entities.credit.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

}
