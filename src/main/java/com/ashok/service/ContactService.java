package com.ashok.service;

import java.util.List;

import com.ashok.entity.Contact;

public interface ContactService {

	
	public boolean saveContact(Contact contact);

	public List<Contact> getAll();

	
	public Contact findSingleContact(int id);

	public boolean deleteContact(int id);

}
