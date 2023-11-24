package com.example.demo.repository;
//JPA insere uma camada entre o banco e o cliente, o jdbc comunica direto com o banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Contato;
@Repository // a notação permite injetar esse repositório;
											//nome da entidade, tipo de dado que a chave primária tem;
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
