package br.com.leandro.varejao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Estado;

public class EstadoDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Estado estado = new Estado();

		estado.setNome("Mato Grosso do Sul");
		estado.setSigla("MS");
		

		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);

	}

	@Test
	@Ignore
	public void listar() {
		EstadoDao estadoDao = new EstadoDao();
		List<Estado> resultado = estadoDao.listar();
		System.out.println("Registros encontrados: " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " " + estado.getNome());
			

		}

	}

	@Test
	@Ignore
	public void consulta() {
		Long codigo = 90L;
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.consultar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println(estado.getSigla() + " " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.consultar(codigo);
		estadoDao.excluir(estado);
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 4L;
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.consultar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Registro antes de atualizar: ");
			System.out.println(estado.getSigla() + " " + estado.getNome());

			estado.setSigla("RS");
			estado.setNome("Rio Grande do Sul");
			estadoDao.editar(estado);

			System.out.println("Registro atualizado: ");
			System.out.println(estado.getSigla() + " " + estado.getNome());
		}

	}

}
