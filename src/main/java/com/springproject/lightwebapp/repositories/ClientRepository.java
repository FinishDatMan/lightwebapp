package com.springproject.lightwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.lightwebapp.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
