package br.org.webgov.action;

import br.org.webgov.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("papelHome")
public class PapelHome extends EntityHome<Papel> {

	public void setPapelId(Integer id) {
		setId(id);
	}

	public Integer getPapelId() {
		return (Integer) getId();
	}

	@Override
	protected Papel createInstance() {
		Papel papel = new Papel();
		return papel;
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

	public Papel getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<UsuarioPapel> getUsuarioPapels() {
		return getInstance() == null ? null : new ArrayList<UsuarioPapel>(
				getInstance().getUsuarioPapels());
	}

}
