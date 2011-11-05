package br.org.webgov.action;

import br.org.webgov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("papelList")
public class PapelList extends EntityQuery<Papel> {

	private static final String EJBQL = "select papel from Papel papel";

	private static final String[] RESTRICTIONS = {
			"lower(papel.descricao) like lower(concat(#{papelList.papel.descricao},'%'))",
			"lower(papel.nome) like lower(concat(#{papelList.papel.nome},'%'))",};

	private Papel papel = new Papel();

	public PapelList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Papel getPapel() {
		return papel;
	}
}
