package com.javatechie.spring.ws.api.repositories.credit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javatechie.spring.ws.api.entities.credit.CreditVoiture;

@Repository
public interface CreditVoitureRepository extends JpaRepository<CreditVoiture, Long> {

}
