package br.com.acoesprojetos.service;

import java.util.List;

import br.com.acoesprojetos.dao.UsuarioDAO;
import br.com.acoesprojetos.model.Usuario;

public class UsuarioService {
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void salvar(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserir(usuario);
	}

	public void editar() {

	}

	public List<Usuario> listar() {
		return usuarioDAO.getLista();
	}

	public Usuario buscarPorId(int id) {
		return usuarioDAO.findById(id);
	}
	
	public Usuario autenticar(Usuario usuario) {
		return usuarioDAO.autenticar(usuario);
	}
	
}
