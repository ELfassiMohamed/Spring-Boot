package com.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entities.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
