package br.com.leandro.varejao.dao;

import org.junit.Test;

import br.com.leandro.varejao.entity.Estado;

public class EstadoDaoTest {

	@Test
	public void salvar() {

		Estado estado = new Estado();

		estado.setNome("São Paulo");
		estado.setSigla("SP");

		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);

	}

}
