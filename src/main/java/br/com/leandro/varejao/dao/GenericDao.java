package br.com.leandro.varejao.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.leandro.varejao.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDao<Entidade> {

	// atributo que descobre qual é o class
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDao() {

		// API Reflection serve para ler informações como classe, método,
		// atributo em tempo de execução
		// o getClass pega a classe pai e pega o tipo generico, e tipo generico
		// pega o tipo da classe genérica
		// e o tipo da classe genérica passa para o this.classe
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
			// Confirma a transação
			transacao.commit();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
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

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		// Abre a fabrica de sessões, pega uma sessão aberta
		Session sessao = HibernateUtil.getFabricasessoes().openSession();

		// Não é necessário transação pois o listar só consulta
		try {
			// Cria uma criterio para listar
			Criteria lista = sessao.createCriteria(classe);
			// Cria variavel que vai retornar a lista
			List<Entidade> resultado = lista.list();
			// Retorna a lista
			return resultado;

		} catch (RuntimeException ex) {
			throw ex;// não fica invisivel o erro
		} finally {// fecha a sessão independente se cair no try ou no catch
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public Entidade consultar(Long codigo) {
		// Abre a fabrica de sessões, pega uma sessão aberta
		Session sessao = HibernateUtil.getFabricasessoes().openSession();

		// Não é necessário transação pois o o método só vai consultar

		try {
			// Cria uma criterio para consultar
			Criteria consulta = sessao.createCriteria(classe);
			// consulta através de uma restrição que é somente pelo que o
			// usuário digitar com a chave primária
			consulta.add(Restrictions.idEq(codigo));
			// Cria variáel que vai retornar uma única consulta e faz uma
			// conversão para o tipo entidade
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException ex) {
			throw ex;// não fica invisivel o erro

		} finally {// fecha a sessão independente se cair no try ou no catch

			sessao.close();
		}

	}

	public void excluir(Entidade entidade) {
		// Abre a fabrica de sessões, pega uma sessão aberta
		Session sessao = HibernateUtil.getFabricasessoes().openSession();
		// Cria uma transação
		Transaction transacao = null;

		try {
			// Inicia a transação
			transacao = sessao.beginTransaction();
			// deleta o objeto
			sessao.delete(entidade);
			// Confirma a transação
			transacao.commit();

		} catch (RuntimeException ex) {
			// desfaz a transação
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex; // repropaga a transação para camadas superiores e não
						// fica invisivel o erro
		} finally {// fecha a sessão independente se cair no try ou no catch
			sessao.close();
		}

	}

	public void editar(Entidade entidade) {
		// Abre a fabrica de sessões, pega uma sessão aberta
		Session sessao = HibernateUtil.getFabricasessoes().openSession();
		// Cria uma transação
		Transaction transacao = null;

		try {
			// Inicia a transação
			transacao = sessao.beginTransaction();
			// atualiza o objeto
			sessao.update(entidade);
			// Confirma a transação
			transacao.commit();

		} catch (RuntimeException ex) {
			// desfaz a transação

			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;// repropaga a transação para camadas superiores e não
						// fica invisivel o erro
		} finally {// fecha a sessão independente se cair no try ou no catch
			sessao.close();
		}
	}
	
	public void merge(Entidade entidade) {
		// Abre a fabrica de sessões, pega uma sessão aberta
		Session sessao = HibernateUtil.getFabricasessoes().openSession();

		// Cria uma transação
		Transaction transacao = null;

		try {
			// Inicia a transação
			transacao = sessao.beginTransaction();
			// Salva o objeto
			sessao.merge(entidade);
			// Confirma a transação
			transacao.commit();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
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
