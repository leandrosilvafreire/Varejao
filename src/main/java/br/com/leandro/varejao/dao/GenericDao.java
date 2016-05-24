package br.com.leandro.varejao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.leandro.varejao.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;

public class GenericDao<Entidade> {
	
	//atributo que descobre qual é o class
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		
		//API Reflection serve para ler informações como classe, método, atributo em tempo de execução
		//o getClass pega a classe pai e pega o tipo generico, e tipo generico pega o tipo da classe genérica 
		//e o tipo da classe genérica passa para o this.classe
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	public void salvar(Entidade entidade) {
		// Abre a fabrica de sessões, pega uma sessão aberta
		Session sessao = HibernateUtil.getFabricasessoes().openSession();

		// Cria uma transação
		Transaction transacao = null;

		try {
			// Inicia a transação
			transacao = sessao.beginTransaction();
			// Salva o objeto
			sessao.save(entidade);
			// Confrima a transação
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				// desfaz a transação
				transacao.rollback();
			}
			// repropaga a transação para camadas superiores e não fica
			// invisivel o erro
			throw ex;

		} finally {// fecha a sessão independente se cair no try ou no catch
			sessao.close();
		}

	}

}
