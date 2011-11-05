package br.org.webgov.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import br.org.webgov.model.Papel;
import br.org.webgov.model.Usuario;
import br.org.webgov.model.UsuarioPapel;

@Name("testedao")
public class TesteDAO {

	@In
	private EntityManager entityManager;

	@Create
	public void create() {
	}

	public String getUsers() {
		Query q = entityManager.createQuery("Select u from Usuario u");
		List<Usuario> usuarios = q.getResultList();
		String retorno = "";
		if (usuarios.size() > 0)
			for (Usuario u : usuarios) {
				if (!retorno.equals(""))
					retorno += "<br/>";
				retorno += u.getNome() + " (" + u.getId() + ")";
				for (UsuarioPapel up : u.getUsuarioPapels()) 
					retorno += "" + up.getPapel().getNome();
			}
		return retorno;
	}

}
