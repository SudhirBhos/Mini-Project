package com.ashok.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashok.entity.Contact;
import com.ashok.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	@Override
	public boolean saveContact(Contact contact) {
		contact.setStatus("y");
		Contact con = contactRepository.save(contact);
		if(con.getCid()>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Contact> getAll() {
		Contact c=new Contact();
		c.setStatus("y");
		return contactRepository.findAll();
	}
	@Override
	public Contact findSingleContact(int id) {
	Optional<Contact> con=contactRepository.findById(id);
		return con.get();
	}
	@Override
	public boolean deleteContact(int id) {
		Optional<Contact> con = contactRepository.findById(id);
		if(con.get().getCid()>0) {
		con.get().setStatus("n");
		contactRepository.save(con.get());
		return true;
		}else {
			return false;
		}
	}

}
