package com.asgnment.contactapp.dao;


import java.util.List;
import java.util.Optional;

import com.asgnment.contactapp.model.Contact;

public interface IContactService {

	List<Contact> getContacts();

	Optional<Contact> getContactById(long id);

	Contact updateContact(Contact Contact);

//	void addContact(String firstName,String lastName, String email, String phoneNumber, String status);

	void deleteContact(long id);
	
	void deleteAllContacts();
	
	Contact saveContact(Contact Contact);

}