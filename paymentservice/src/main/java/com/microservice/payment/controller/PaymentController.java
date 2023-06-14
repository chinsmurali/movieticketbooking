
package com.microservice.payment.controller;

import java.util.List;


import com.microservice.payment.modal.payment;
import com.microservice.payment.service.PaymentService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class PaymentController
{
	@Autowired
	PaymentService paymentService;
	
	  @PostMapping("/initiate")
    public ResponseEntity  initiatePayment(@RequestParam("amount") String amount, @RequestBody InitiateRequest request, @RequestParam("userId") Long userId,@RequestParam("ticketId") Long ticketId){
        return paymentService.initiatePayment(amount, request, userId, ticketId);

}