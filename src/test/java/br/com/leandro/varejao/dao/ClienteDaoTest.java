package br.com.leandro.varejao.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Cliente;
import br.com.leandro.varejao.entity.Pessoa;

public class ClienteDaoTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(true);

		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(1L);
		cliente.setPessoa(pessoa);

		Cliente cliente2 = new Cliente();
		// outra forma de pegar qualquer data
		cliente2.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2016"));
		cliente2.setLiberado(false);

		PessoaDao pessoaDao2 = new PessoaDao();
		Pessoa pessoa2 = pessoaDao2.consultar(2L);
		cliente2.setPessoa(pessoa2);

		ClienteDao clienteDao = new ClienteDao();
		clienteDao.salvar(cliente);
		clienteDao.salvar(cliente2);

	}

	@Test
	@Ignore
	public void listar() {

		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> lista = clienteDao.listar();

		for (Cliente cliente : lista) {

			System.out.println();
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("Liberado: " + cliente.getLiberado());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void consultar() {
		Long codigo = 4L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.consultar(codigo);

		System.out.println();
		System.out.println("Código: " + cliente.getCodigo());
		System.out.println("Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Data Cadastro: " + cliente.getDataCadastro());
		System.out.println("Liberado: " + cliente.getLiberado());
		System.out.println();

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 5L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.consultar(codigo);
		clienteDao.excluir(cliente);
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 3L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.consultar(codigo);

		cliente.setDataCadastro(new Date());
		cliente.setLiberado(true);

		Long pess = 6L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(pess);
		cliente.setPessoa(pessoa);

		clienteDao.editar(cliente);
	}

}
