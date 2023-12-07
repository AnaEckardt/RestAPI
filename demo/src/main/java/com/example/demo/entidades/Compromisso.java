package com.example.demo.entidades;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_compromissos")
public class Compromisso {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private int idlocal;
	private int idcontato;
	private Date data;
	private Time hora;
	private String status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdlocal() {
		return idlocal;
	}
	public void setIdlocal(int idlocal) {
		this.idlocal = idlocal;
	}
	public int getIdcontato() {
		return idcontato;
	}
	public void setIdcontato(int idcontato) {
		this.idcontato = idcontato;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		
	}
	
	
	public Compromisso(int id, int idlocal, int idcontato, Date data, Time hora, String status) {
		this.id = id;
		this.idlocal = idlocal;
		this.idcontato = idcontato;
		this.data = data;
		this.hora = hora;
		this.status = status;
	}
	
	
	public Compromisso() {
	}
	
	
	
	
	
	
	

}
