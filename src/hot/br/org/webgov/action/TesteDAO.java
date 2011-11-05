package br.org.webgov.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import br.org.webgov.model.Usuario;

@Name("testedao")
public class TesteDAO {
	
	@In
	EntityManager entityManager;
	
	@Create
	public void create() {}
	
	public String getUsers() {
		Query q = entityManager.createQuery("Select u from Usuario u");
		List<Usuario> usuarios = q.getResultList();
		String retorno = "";
		if (usuarios.size() > 0)
			for (Usuario u : usuarios) {
				if (!retorno.equals("")) retorno += "\n";
				retorno += u.getNome() + " (" + u.getId() + ")";
			}
		return retorno;
	}
	

}
