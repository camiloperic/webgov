package br.org.webgov.action;

import javax.ejb.Local;

@Local
public interface ITesteBean {

	public String getMensagem();

	public void mudarMensagem();

}
