package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Compromisso;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{

}
