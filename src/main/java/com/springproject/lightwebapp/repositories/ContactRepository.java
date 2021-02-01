package com.springproject.lightwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.lightwebapp.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
