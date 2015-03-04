package br.com.guiamochileiro.gm.entidades;

public class Usuario {
	public int id;
	public String nomeUsuario;
	public String senha;
	private int senhaSalva;
	
	//constructor
	public Usuario(String nome, String email, String senha){		
	}
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String usuario) {
		this.nomeUsuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setPassword(String senha) {
		this.senha = senha;
	}
	
	public boolean autentica(String senha, String senhaSalva){
		if(senha.equals(senhaSalva)){
			return true;
		}else if(!senha.equals(senhaSalva)){
			return false;						
		}else
		return false;
	}
	
}
