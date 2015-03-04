package br.com.guiamochileiro.gm.entidades;

import java.io.Serializable;

public class Muchileiro extends Usuario implements Serializable{	
	private String nome;
	private String email;
		
	//constructor
	public Muchileiro(String nome, String email, String senha){	
		super(nome, email, senha);
	}
	
	//getters and setters
	
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

		
}
