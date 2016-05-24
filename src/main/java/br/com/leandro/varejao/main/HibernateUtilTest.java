package br.com.leandro.varejao.main;

import org.hibernate.Session;

import br.com.leandro.varejao.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {
	     
		//Abre a Sessão
		Session sessao = HibernateUtil.getFabricasessoes().openSession();
		
		//Fecha a Sessão
		sessao.close();
		
		//Destói a fabrica de sessão
		HibernateUtil.getFabricasessoes().close();

	}

}
