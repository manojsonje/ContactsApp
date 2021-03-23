package com.asgnment.contactapp.controller;

import com.asgnment.contactapp.dao.IContactService;
import com.asgnment.contactapp.model.Contact;
import com.asgnment.contactapp.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

	@Autowired
	private IContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> findAll(){
    	List<Contact> contactList = contactService.getContacts();
    	if(!contactList.isEmpty()) {
    		return ResponseEntity.ok().body(contactList);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Contact> findById(@PathVariable long id){
        return contactService.getContactById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Contact> update(@PathVariable("id") long id, @RequestBody Contact contact){
      return contactService.getContactById(id)
          .map(record -> {
              record.setFirstName(contact.getFirstName());
              record.setLastName(contact.getLastName());
              record.setEmail(contact.getEmail());
              record.setPhoneNumber(contact.getPhoneNumber());
              record.setStatus(contact.getStatus());
              Contact updated = contactService.updateContact(record);
              return ResponseEntity.ok().body(updated);
          }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value ={"/deletecontact/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
      return contactService.getContactById(id)
          .map(record -> {
        	  contactService.deleteContact(record.getId());
              return ResponseEntity.ok().build();
          }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
    	List<Contact> contactList = contactService.getContacts();
    	contactService.deleteAllContacts();
    	if(!contactList.isEmpty()) {
    		return ResponseEntity.ok().build();
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }
}
