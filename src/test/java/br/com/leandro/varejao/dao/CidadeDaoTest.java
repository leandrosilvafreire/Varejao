package br.com.leandro.varejao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Cidade;
import br.com.leandro.varejao.entity.Estado;

public class CidadeDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Cidade cidade = new Cidade();

		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.consultar(2L);
		cidade.setEstado(estado);
		cidade.setNome("São Paulo");

		CidadeDao cidadedao = new CidadeDao();
		cidadedao.salvar(cidade);

	}

	@Test
	@Ignore
	public void listar() {
		CidadeDao cidadeDao = new CidadeDao();
		List<Cidade> resultado = cidadeDao.listar();

		for (Cidade cidade : resultado) {
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Cidade: " + cidade.getNome());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();

		}

	}

	@Test
	@Ignore
	public void consulta() {
		Long codigo = 4L;
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.consultar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado!");

		} else {
			System.out.println();
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Cidade: " + cidade.getNome());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 8L;
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.consultar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			cidadeDao.excluir(cidade);
			System.out.println();
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Cidade: " + cidade.getNome());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();

		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		Long estado = 10L;

		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.consultar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {

			EstadoDao estadoDao = new EstadoDao();
			Estado estados = estadoDao.consultar(estado);

			System.out.println();
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Cidade: " + cidade.getNome());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();

			cidade.setEstado(estados);
			cidade.setNome("Claraval");

			cidadeDao.editar(cidade);

			System.out.println();
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Cidade: " + cidade.getNome());
			System.out.println("Sigla Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome Estado: " + cidade.getEstado().getNome());
			System.out.println();

		}

	}

}
