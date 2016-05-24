package br.com.leandro.varejao.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	// Cria uma váriavel que retorna sessões
	private static final SessionFactory fabricaSessoes = criaFabricaSessoes();

	public static SessionFactory getFabricasessoes() {
		return fabricaSessoes;
	}

	private static SessionFactory criaFabricaSessoes() {
		try{
			//Lê o arquivo hibernate cfg e busca suas configurações
			Configuration configuracao = new Configuration().configure();
			
			//Cria o registro
			ServiceRegistry resgistro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			//construindo a fabrica de sessoes
			SessionFactory fabrica = configuracao.buildSessionFactory(resgistro);
			
			return fabrica;
			
		}catch(Throwable ex){
			System.err.println("Falha na criação da fábrica de sessões." + ex);
			throw new ExceptionInInitializerError(ex);//Mostra a mensagem para a aplicação
		}
		
	}

}
