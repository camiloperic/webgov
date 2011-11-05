package br.org.webgov.action;

import br.org.webgov.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("usuarioHome")
public class UsuarioHome extends EntityHome<Usuario> {

	public void setUsuarioId(Integer id) {
		setId(id);
	}

	public Integer getUsuarioId() {
		return (Integer) getId();
	}

	@Override
	protected Usuario createInstance() {
		Usuario usuario = new Usuario();
		return usuario;
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

	public Usuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<UsuarioPapel> getUsuarioPapels() {
		return getInstance() == null ? null : new ArrayList<UsuarioPapel>(
				getInstance().getUsuarioPapels());
	}

}
