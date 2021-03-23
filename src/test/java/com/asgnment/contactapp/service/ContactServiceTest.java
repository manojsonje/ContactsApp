package com.asgnment.contactapp.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.junit.Before;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.asgnment.contactapp.model.Contact;
import com.asgnment.contactapp.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

	@InjectMocks
	ContactService contactService ;

//	ContactService contactService = new ContactService();
	
//	@Mock
//	ContactRepository contactRepository;
	ContactRepository contactRepository = mock(ContactRepository.class);

	
//	@SuppressWarnings("deprecation")
//	@Before
//    public void initMocks(){
//        MockitoAnnotations.initMocks(this);
//    }

	@Test
	void getAllContactsTest() {
		List<Contact> contactList = new ArrayList<Contact>();
		Contact c1Contact = new Contact(1L,"fnametst1","lnametst1","emailtst1","pnumbertst1","Active");
		Contact c2Contact = new Contact(2L,"fnametst2","lnametst2","emailtst2","pnumbertst2","Active");
		contactList.add(c1Contact);
		contactList.add(c2Contact);
		
		when(contactRepository.findAll()).thenReturn(contactList);
		List<Contact> cList = contactService.getContacts();

		assertEquals(2,cList.size());
		verify(contactRepository, times(1)).findAll();
	}
	
	@Test
	void getContactByIdTest() {
		Contact c1Contact = new Contact(1L,"fnametst1","lnametst1","emailtst1","pnumbertst1","Active");
				
		Long id = 1L;
		
		when(contactRepository.findById(id)).thenReturn(Optional.of(c1Contact));
		Optional<Contact> contact = contactService.getContactById(id);
		Contact actualContactObj = contact.get();
		assertEquals(id,actualContactObj.getId());
//		verify(contactRepository, times(1)).findById();
	}
	
	@Test
	void updateContactTest() {
		Contact c1Contact = new Contact(1L,"fnametst1","lnametst1","emailtst1","pnumbertst1","Active");
		
		Long id = 1L;
		
		when(contactRepository.save(c1Contact)).thenReturn(c1Contact);
		Contact contact = contactService.updateContact(c1Contact);
	
		assertEquals(id,contact.getId());
//		verify(contactRepository, times(1)).updateContact();
	}
	
	@Test
	void deleteContactTest() {
		Contact c1Contact = new Contact(1L,"fnametst1","lnametst1","emailtst1","pnumbertst1","Active");
		Long id = 1L;

		when(contactRepository.findById(id)).thenReturn(Optional.of(c1Contact));
		contactService.deleteContact(c1Contact.getId());
	
		verify(contactRepository, times(1)).findById(c1Contact.getId());
		verify(contactRepository, times(1)).delete(c1Contact);

	}
	
	@Test
	void saveContactTest() {
		Contact c1Contact = new Contact(1L,"fnametst1","lnametst1","emailtst1","pnumbertst1","Active");

		when(contactRepository.save(c1Contact)).thenReturn(c1Contact);
		Contact contact = contactService.saveContact(c1Contact);
	
		assertEquals(c1Contact.getId(),contact.getId());
		
		verify(contactRepository, times(1)).save(c1Contact);
	}
	
//	@Test
//	void deleteAllContactsTest() {
//		contactService.deleteAllContacts();
//		verify(contactRepository, times(1)).deleteAllContacts();
//	}

}
