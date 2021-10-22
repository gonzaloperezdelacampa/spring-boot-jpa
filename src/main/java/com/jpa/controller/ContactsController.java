package com.jpa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.exceptions.ContactNotFoundException;
import com.jpa.model.Contacts;
import com.jpa.repository.ContactRepository;

@RestController
@RequestMapping("contacts")
public class ContactsController {

	private final ContactRepository repository;

	public ContactsController(ContactRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Iterable<Contacts> getContacts() {
		return repository.findAll();
	}	

	@GetMapping("{id}")
	public Contacts getContact(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(ContactNotFoundException::new);
	}

	@PostMapping
	public Contacts addContact(@RequestBody Contacts Contact) {
		return repository.save(Contact);
	}

	@PutMapping("{id}")
	public Contacts updateContact(@PathVariable Long id, @RequestBody Contacts Contact) {
		Contacts ContactToUpdate = repository.findById(id).orElseThrow(ContactNotFoundException::new);

		ContactToUpdate.setName(Contact.getName());
		ContactToUpdate.setTelefone(Contact.getTelefone());
		ContactToUpdate.setEmail( Contact.getEmail());

		return repository.save(ContactToUpdate);
	}

	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable Long id) {
		repository.findById(id).orElseThrow(ContactNotFoundException::new);
		repository.deleteById(id);
	}
}
