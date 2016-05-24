package br.com.leandro.varejao.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTeste {

	@Test
	public void conectar() {

		// Abre a Sessão
		Session sessao = HibernateUtil.getFabricasessoes().openSession();

		// Fecha a Sessão
		sessao.close();

		// Destrói a fabrica de sessão
		HibernateUtil.getFabricasessoes().close();

	}

}
