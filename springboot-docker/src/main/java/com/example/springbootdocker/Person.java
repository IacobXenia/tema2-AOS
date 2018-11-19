package com.example.springbootdocker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String nume;
	private String prenume;
	
	public Person() {
		super();
	}

	public Person(Long id, String nume, String prenume) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	

}
