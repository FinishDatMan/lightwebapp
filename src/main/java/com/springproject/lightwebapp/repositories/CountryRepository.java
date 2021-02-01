package com.springproject.lightwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.lightwebapp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
