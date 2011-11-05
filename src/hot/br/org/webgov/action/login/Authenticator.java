package br.org.webgov.action.login;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
