package br.org.webgov.action;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("testebean")
@Stateless
public class TesteBean implements ITesteBean {

	@In(create = true)
	private TesteDAO testedao;

	@In
	EntityManager entityManager;

	private String mensagem = "Teste que vai funcionar, é muito fácil!";

	public void mudarMensagem() {
		mensagem = testedao.getUsers();
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
