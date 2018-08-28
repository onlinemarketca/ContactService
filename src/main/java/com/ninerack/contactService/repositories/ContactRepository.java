package com.ninerack.contactService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninerack.contactService.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	public Contact findById(long id);
	
}