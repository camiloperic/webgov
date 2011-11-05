package br.org.webgov.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
