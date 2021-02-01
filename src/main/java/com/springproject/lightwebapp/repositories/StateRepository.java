package com.springproject.lightwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.lightwebapp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
