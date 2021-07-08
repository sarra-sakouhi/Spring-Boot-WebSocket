package com.softib.spring.ws.api.controllers.credit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softib.spring.ws.api.entities.credit.Credit;
import com.softib.spring.ws.api.entities.credit.CreditDirect;
import com.softib.spring.ws.api.services.credit.CreditServiceImpl;



@RestController
@RequestMapping("/softib/credit/")
public class CreditController {
	@Autowired
	private CreditServiceImpl creditService;

	@GetMapping("/credits")
	public List<Credit> getAllCredits(){

		return creditService.getAllCredits();
	}

	@PostMapping("/credits")
	public Credit createCredit(@RequestBody Credit credit) {

		return creditService.createCredit(credit);
	}
	
	@PostMapping("/direct")
    public Credit addToDirect(@RequestBody CreditDirect credit) {
		return creditService.addToDirect(credit);
	}

	@GetMapping("/credits/{id}")
	public ResponseEntity<Credit> getCreditById(@PathVariable long id) {

		Credit credit=creditService.getCreditById(id);
		return ResponseEntity.ok(credit);
	}
	
	@GetMapping("/direct/{id}")
	public ResponseEntity<CreditDirect> getDirectById(@PathVariable long id) {

		CreditDirect credit=creditService.getDirectById(id);
		return ResponseEntity.ok(credit);
	}

	@PutMapping("/credits/{id}")
	public ResponseEntity<Credit> updateCredit(@PathVariable long id, @RequestBody Credit creditWithUpdates){

		Credit updatedCredit=creditService.updateCredit(id,creditWithUpdates);
		return ResponseEntity.ok(updatedCredit);
	}

	@DeleteMapping("/credits/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteCredit(@PathVariable long id){

		creditService.deleteCredit(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}
