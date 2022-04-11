package com.ashok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.entity.Contact;
import com.ashok.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/save")
	public String saveContact(@RequestBody Contact contact) {
		boolean status = contactService.saveContact(contact);
		if (status) {
			return "Contact Save";
		} else {
			return "Contact Not Save";
		}
	}

	@GetMapping("/")
	public List<Contact> getContact() {
		return contactService.getAll();
	}

	@GetMapping("/contact/{id}")
	public Contact getSingleContact(@PathVariable int id) {
		return contactService.findSingleContact(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteContact(@PathVariable int id) {
		boolean status = contactService.deleteContact(id);
		if(status) {
			return "delete Contact";
		}else {
			return "Not Delete Contact";
		}
	}

}
