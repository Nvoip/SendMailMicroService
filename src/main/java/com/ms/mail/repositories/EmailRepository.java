package com.ms.mail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.mail.models.EmailModel;

public interface EmailRepository  extends JpaRepository<EmailModel, Long>{

}
