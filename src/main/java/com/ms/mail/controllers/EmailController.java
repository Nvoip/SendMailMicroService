package com.ms.mail.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.mail.dtos.EmailDTO;
import com.ms.mail.models.EmailModel;
import com.ms.mail.services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDto){
		
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		emailService.sendEmail(emailModel);
		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
		
	}

}
