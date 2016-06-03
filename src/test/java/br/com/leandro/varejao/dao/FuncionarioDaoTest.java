package br.com.leandro.varejao.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Funcionario;
import br.com.leandro.varejao.entity.Pessoa;

public class FuncionarioDaoTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Funcionario funcionario = new Funcionario();

		funcionario.setCarteira("90.100");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2012"));

		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(6L);
		funcionario.setPessoa(pessoa);

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.salvar(funcionario);
	}

	@Test
	@Ignore
	public void listar() {

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> lista = funcionarioDao.listar();

		for (Funcionario funcionario : lista) {

			System.out.println();
			System.out.println("Código: " + funcionario.getCodigo());
			System.out.println("Funcionário: " + funcionario.getPessoa().getNome());
			System.out.println("Carteira: " + funcionario.getCarteira());
			System.out.println("Data Admissão: " + funcionario.getDataAdmissao());
			System.out.println();

		}
	}

	@Test
	@Ignore
	public void consultar() {
		Long func = 4L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.consultar(func);

		System.out.println();
		System.out.println("Código: " + funcionario.getCodigo());
		System.out.println("Funcionário: " + funcionario.getPessoa().getNome());
		System.out.println("Carteira: " + funcionario.getCarteira());
		System.out.println("Data Admissão: " + funcionario.getDataAdmissao());
		System.out.println();
	}

	@Test
	@Ignore
	public void excluir() {
		Long func = 5L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.consultar(func);
		funcionarioDao.excluir(funcionario);

	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long func = 4L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.consultar(func);

		funcionario.setCarteira("41.745");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2015"));

		Long pess = 1L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(pess);
		funcionario.setPessoa(pessoa);

		funcionarioDao.editar(funcionario);
	}

}
