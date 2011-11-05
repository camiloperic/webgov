package br.org.webgov.action;

import br.org.webgov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("usuarioList")
public class UsuarioList extends EntityQuery<Usuario> {

	private static final String EJBQL = "select usuario from Usuario usuario";

	private static final String[] RESTRICTIONS = {
			"lower(usuario.nome) like lower(concat(#{usuarioList.usuario.nome},'%'))",
			"lower(usuario.password) like lower(concat(#{usuarioList.usuario.password},'%'))",
			"lower(usuario.username) like lower(concat(#{usuarioList.usuario.username},'%'))",};

	private Usuario usuario = new Usuario();

	public UsuarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
