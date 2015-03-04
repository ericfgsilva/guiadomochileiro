package br.com.guiamochileiro.gm.negocio;

import java.rmi.RemoteException;

import br.com.guiamochileiro.gm.entidades.Usuario;
import br.com.guiamochileiro.gm.interfaces.RepositorioUsuario;
import br.com.guiamochileiro.gm.negocio.excecoes.CampoNumericoPreenchidoComLetrasException;
import br.com.guiamochileiro.gm.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.guiamochileiro.gm.negocio.excecoes.UsuarioInvalidoException;
import br.com.guiamochileiro.gm.negocio.excecoes.UsuarioJaCadastradoException;
import br.com.guiamochileiro.gm.negocio.excecoes.UsuarioNaoCadastradoException;

public class CadastroUsuario {

	private RepositorioUsuario respositorioUsuarios;
		
	public CadastroUsuario(RepositorioUsuario r) {
		this.respositorioUsuarios = r;
	}
	
	public void validar(Usuario usuario) 
			throws CampoNumericoPreenchidoComLetrasException, 
				   CampoObrigatorioNaoPreenchidoException,
				   UsuarioInvalidoException {
		if (usuario == null) {
			throw new UsuarioInvalidoException("Usuario não informado !");
		}
		usuario.setNomeUsuario(usuario.getNomeUsuario().toUpperCase());
		
		if (usuario.getNomeUsuario() == null || usuario.getNomeUsuario().isEmpty()) {
			throw new CampoObrigatorioNaoPreenchidoException("Favor informar o nome do Usuario !");
		}
	}
	
	public void cadastrar(Usuario u) throws UsuarioJaCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, UsuarioInvalidoException, UsuarioNaoCadastradoException, RemoteException {
		if (!respositorioUsuarios.existe(u.getNomeUsuario())) {
			validar(u);
			respositorioUsuarios.inserir(u);		
		} else {  
			throw new UsuarioJaCadastradoException("Usuario já cadastrado !");
		}
	}
	
	public void descadastrar(String n) throws UsuarioNaoCadastradoException, RemoteException {
		respositorioUsuarios.remover(n);
	}
	
	public Usuario procurar(String n) throws UsuarioNaoCadastradoException, RemoteException {
		return respositorioUsuarios.procurar(n);
	}
	
	public void atualizar(Usuario u) throws UsuarioNaoCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, UsuarioInvalidoException, RemoteException {
		validar(u);
		respositorioUsuarios.atualizar(u);
		
	}
	
	
}
