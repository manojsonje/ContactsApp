package com.asgnment.contactapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asgnment.contactapp.dao.IContactService;

import com.asgnment.contactapp.model.Contact;
import com.asgnment.contactapp.repository.ContactRepository;

@Service
public class ContactService implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Optional<Contact> getContactById(long id) {
		return contactRepository.findById(id);
	}

	@Override
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

//	@Override
//	public void addContact(String firstName, String lastName, String email, String phoneNumber, String status) {
//		contactRepository.save(new Contact(firstName, lastName, email, phoneNumber,status));
//	}

	@Override
	public void deleteContact(long id) {
		Optional<Contact> Contact = contactRepository.findById(id);
		if (Contact.isPresent()) {
			contactRepository.delete(Contact.get());
		}
	}

	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void deleteAllContacts() {
		contactRepository.deleteAll();		
	}

	
}