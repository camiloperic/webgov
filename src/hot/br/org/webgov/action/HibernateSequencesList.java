package br.org.webgov.action;

import br.org.webgov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("hibernateSequencesList")
public class HibernateSequencesList extends EntityQuery<HibernateSequences> {

	private static final String EJBQL = "select hibernateSequences from HibernateSequences hibernateSequences";

	private static final String[] RESTRICTIONS = {"lower(hibernateSequences.id.sequenceName) like lower(concat(#{hibernateSequencesList.hibernateSequences.id.sequenceName},'%'))",};

	private HibernateSequences hibernateSequences;

	public HibernateSequencesList() {
		hibernateSequences = new HibernateSequences();
		hibernateSequences.setId(new HibernateSequencesId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public HibernateSequences getHibernateSequences() {
		return hibernateSequences;
	}
}
