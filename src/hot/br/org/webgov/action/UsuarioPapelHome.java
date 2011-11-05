package br.org.webgov.action;

import br.org.webgov.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("usuarioPapelHome")
public class UsuarioPapelHome extends EntityHome<UsuarioPapel> {

	@In(create = true)
	PapelHome papelHome;
	@In(create = true)
	UsuarioHome usuarioHome;

	public void setUsuarioPapelId(UsuarioPapelId id) {
		setId(id);
	}

	public UsuarioPapelId getUsuarioPapelId() {
		return (UsuarioPapelId) getId();
	}

	public UsuarioPapelHome() {
		setUsuarioPapelId(new UsuarioPapelId());
	}

	@Override
	public boolean isIdDefined() {
		if (getUsuarioPapelId().getIdPapel() == null)
			return false;
		if (getUsuarioPapelId().getIdUsuario() == null)
			return false;
		return true;
	}

	@Override
	protected UsuarioPapel createInstance() {
		UsuarioPapel usuarioPapel = new UsuarioPapel();
		usuarioPapel.setId(new UsuarioPapelId());
		return usuarioPapel;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Papel papel = papelHome.getDefinedInstance();
		if (papel != null) {
			getInstance().setPapel(papel);
		}
		Usuario usuario = usuarioHome.getDefinedInstance();
		if (usuario != null) {
			getInstance().setUsuario(usuario);
		}
	}

	public boolean isWired() {
		return true;
	}

	public UsuarioPapel getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
