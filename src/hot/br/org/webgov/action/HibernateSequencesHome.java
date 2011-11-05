package br.org.webgov.action;

import br.org.webgov.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("hibernateSequencesHome")
public class HibernateSequencesHome extends EntityHome<HibernateSequences> {

	public void setHibernateSequencesId(HibernateSequencesId id) {
		setId(id);
	}

	public HibernateSequencesId getHibernateSequencesId() {
		return (HibernateSequencesId) getId();
	}

	public HibernateSequencesHome() {
		setHibernateSequencesId(new HibernateSequencesId());
	}

	@Override
	public boolean isIdDefined() {
		if (getHibernateSequencesId().getSequenceName() == null
				|| "".equals(getHibernateSequencesId().getSequenceName()))
			return false;
		if (getHibernateSequencesId().getSequenceNextHiValue() == null)
			return false;
		return true;
	}

	@Override
	protected HibernateSequences createInstance() {
		HibernateSequences hibernateSequences = new HibernateSequences();
		hibernateSequences.setId(new HibernateSequencesId());
		return hibernateSequences;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public HibernateSequences getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
