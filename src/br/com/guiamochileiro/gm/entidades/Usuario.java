package br.com.guiamochileiro.gm.entidades;

public class Usuario {
	public int id;
	public String usuario;
	public int senha;
	private int senhaSalva;
	
	//constructor
	public Usuario(){		
	}
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getSenha() {
		return senha;
	}

	public void setPassword(int senha) {
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
