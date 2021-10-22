package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.model.Contacts;

public interface ContactRepository extends CrudRepository<Contacts, Long> {

}
