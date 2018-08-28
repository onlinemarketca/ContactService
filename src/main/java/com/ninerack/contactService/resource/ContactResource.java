package com.ninerack.contactService.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ninerack.contactService.model.Contact;
import com.ninerack.contactService.repositories.ContactRepository;

@RestController
@RequestMapping("/contact")
@CrossOrigin
public class ContactResource {
	
	private ContactRepository contactRepository;
	
	public ContactResource(ContactRepository contactRepository) {
		this.contactRepository= contactRepository;
	}

	@PostMapping("/add")
	public Contact add(@RequestBody final Contact contact) {
		return this.contactRepository.save(contact);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Contact getBusinessById(@RequestBody @PathVariable("id") final long id
            ) {
		Contact contact = this.contactRepository.findById(id);
		return contact;
	}
}
