package com.example.demo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name = "tb_contatos")
public class Contato {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 100, nullable = false) // alterar tamanho do 
	private String email;
	@Transient  //anotação pro atributo não ir pra tabela no banco de dados.
	private String observacao;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Contato() {
	}
	
	public Contato(int id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
}
