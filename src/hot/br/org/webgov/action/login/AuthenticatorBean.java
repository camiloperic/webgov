package br.org.webgov.action.login;

import javax.ejb.Stateless;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import br.org.webgov.action.dao.Login;
import br.org.webgov.model.Usuario;
import br.org.webgov.model.UsuarioPapel;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator {
	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;

	@In(create = true)
	private Login login;

	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		Usuario usuario = login.doLogin(credentials.getUsername(), credentials.getPassword());
		if (usuario == null) return false;
		else {
			for (UsuarioPapel up : usuario.getUsuarioPapels())
				identity.addRole(up.getPapel().getNome());
			return true;
		}
	}

}
