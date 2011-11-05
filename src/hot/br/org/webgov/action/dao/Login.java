package br.org.webgov.action.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import br.org.webgov.model.Usuario;

@Name("login")
public class Login {

	@In
	private EntityManager entityManager;

	@Create
	public void create() {
	}

	public Usuario doLogin(String username, String password) {
		List<Usuario> usuario = 
			entityManager
			.createQuery(
				"SELECT u " + 
				"FROM Usuario u " + 
				"WHERE username = :username " + 
					"AND password = :password")
			.setParameter("username", username)
			.setParameter("password", password)
			.getResultList();
		if (usuario.size() == 1)
			return usuario.get(0);
		else
			return null;
	}

}
