package br.com.guiamochileiro.gm.interfaces;

import br.com.guiamochileiro.gm.entidades.Usuario;
import br.com.guiamochileiro.gm.negocio.excecoes.UsuarioNaoCadastradoException;

public interface RepositorioUsuario {
	
	void inserir(Usuario u);
	Usuario procurar(String id) throws UsuarioNaoCadastradoException;
	void remover(String id) throws UsuarioNaoCadastradoException;
	boolean existe(String id) throws UsuarioNaoCadastradoException;
	void atualizar(Usuario u) throws UsuarioNaoCadastradoException;

}
