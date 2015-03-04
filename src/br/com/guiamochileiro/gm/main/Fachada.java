package br.com.guiamochileiro.gm.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.guiamochileiro.gm.entidades.Usuario;
import br.com.guiamochileiro.gm.interfaces.RepositorioUsuario;
import br.com.guiamochileiro.gm.negocio.CadastroUsuario;
import br.com.guiamochileiro.gm.negocio.excecoes.CampoNumericoPreenchidoComLetrasException;
import br.com.guiamochileiro.gm.negocio.excecoes.CampoObrigatorioNaoPreenchidoException;
import br.com.guiamochileiro.gm.negocio.excecoes.UsuarioInvalidoException;
import br.com.guiamochileiro.gm.negocio.excecoes.UsuarioJaCadastradoException;
import br.com.guiamochileiro.gm.negocio.excecoes.UsuarioNaoCadastradoException;

public class Fachada {

	//1 - referência de si mesmo
	private static Fachada instancia;
	
	private CadastroUsuario cadastroUsuarios;
	
	//2 - Construtor privado
	private Fachada() {
		initCadastros();
	}
	
	//3 - Método de acesso à referencia de si mesma
	public static Fachada obterInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private void initCadastros() {
		RepositorioUsuario repUsuarios = null;
		try {
			repUsuarios = (RepositorioUsuario) Naming.lookup("//localhost/repositorio");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cadastroUsuarios = new CadastroUsuario(repUsuarios);
	}

	public void atualizar (Usuario u) throws UsuarioNaoCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, UsuarioInvalidoException, RemoteException {
		cadastroUsuarios.atualizar(u);
	}
	public Usuario procurarUsuario(String id) throws UsuarioNaoCadastradoException, RemoteException {
		return cadastroUsuarios.procurar(id);
	}
	public void cadastrar(Usuario u) throws UsuarioJaCadastradoException, CampoNumericoPreenchidoComLetrasException, CampoObrigatorioNaoPreenchidoException, UsuarioInvalidoException, UsuarioNaoCadastradoException, RemoteException {
		cadastroUsuarios.cadastrar(u);
	}
	public void descadastrarUsuario(String id) throws UsuarioNaoCadastradoException, RemoteException {
		cadastroUsuarios.descadastrar(id);
	}

}
