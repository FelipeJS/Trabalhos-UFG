package br.com.acoesprojetos.dao;

import br.com.acoesprojetos.model.Usuario;


public class UsuarioDAO extends BaseDao<Usuario, Integer> {
	
	public Usuario autenticar(Usuario usuario) {
		Usuario user = null;
		try {
			user = (Usuario) super.getEntityManager().createNamedQuery("Usuario.autenticar")
				.setParameter("login", usuario.getLogin())
				.setParameter("senha", usuario.getSenha()).getSingleResult();
		} catch (Exception e) {
			System.out.println("Usuario não encontrado - " + e.getMessage());
			user = null;
		}
		return user;
	}
	
}
