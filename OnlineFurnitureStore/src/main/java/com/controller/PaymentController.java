package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Bill;
import com.entity.Card;
import com.service.IPaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	IPaymentService paymentService;
	
	//To fetch Bill details from the database
	@GetMapping(path = "/getBillByIdeDetalis/{billNo}")
	public ResponseEntity<Bill> getBillById(@RequestParam long billNo) throws Exception
	{
		return new ResponseEntity<>(paymentService.getBillById(billNo), HttpStatus.OK);
	}
	
	//To Make the payment by cash
	@PutMapping("/payByCash/{amount}")
	public ResponseEntity<String> payByCash(@RequestParam double amount) throws Exception 
	{
		double change = paymentService.payByCash(amount);
		if (change == 0) 
		{
			return new ResponseEntity<>("Your transaction is completed.. ", HttpStatus.OK);
		} 
		else if (change < 0) 
		{
			return new ResponseEntity<>("Please take the change: " + change, HttpStatus.OK);
		} else 
		{
			return new ResponseEntity<>("Your Due amount is: " + change, HttpStatus.OK);
		}
	}

	
	//To Make the payment by card
	@PostMapping(path = "/payByCard")
	public ResponseEntity<String> payByCard(@RequestBody Card card) throws Exception
	{
		Card result = paymentService.payByCard(card);
		return new ResponseEntity<>("Transaction is completed for the card: " + result.getCardNumber(), HttpStatus.OK);
	}
	
	
}
