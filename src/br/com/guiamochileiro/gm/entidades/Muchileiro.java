package br.com.guiamochileiro.gm.entidades;

public class Muchileiro extends Usuario{
	public int id;
	public String nome;
	public String email;
	public String usuario;
	
	//constructor
	public Muchileiro(){		
	}
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
		
}
