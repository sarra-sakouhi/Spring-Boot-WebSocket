package com.javatechie.spring.ws.api.repositories.credit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javatechie.spring.ws.api.entities.credit.CreditDirect;

@Repository
public interface CreditDirectRepository extends JpaRepository<CreditDirect, Long> {

}
