package br.org.webgov.action;

import br.org.webgov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("usuarioPapelList")
public class UsuarioPapelList extends EntityQuery<UsuarioPapel> {

	private static final String EJBQL = "select usuarioPapel from UsuarioPapel usuarioPapel";

	private static final String[] RESTRICTIONS = {};

	private UsuarioPapel usuarioPapel;

	public UsuarioPapelList() {
		usuarioPapel = new UsuarioPapel();
		usuarioPapel.setId(new UsuarioPapelId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public UsuarioPapel getUsuarioPapel() {
		return usuarioPapel;
	}
}
