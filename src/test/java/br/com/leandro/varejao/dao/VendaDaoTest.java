package br.com.leandro.varejao.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Cliente;
import br.com.leandro.varejao.entity.Funcionario;
import br.com.leandro.varejao.entity.Venda;

public class VendaDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Venda venda = new Venda();

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.consultar(2L);
		venda.setFuncionario(funcionario);

		venda.setHorario(new Date());

		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.consultar(2L);
		venda.setCliente(cliente);

		venda.setValorTotal(new BigDecimal("51.23"));


		VendaDao vendaDao = new VendaDao();
		vendaDao.salvar(venda);

	}

	@Test
	@Ignore
	public void listar() {
		VendaDao vendaDao = new VendaDao();
		List<Venda> lista = vendaDao.listar();

		for (Venda venda : lista) {

			System.out.println();
			System.out.println("Código: " + venda.getCodigo());
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Horário: " + venda.getHorario());
			System.out.println("Valor Total R$: " + venda.getValorTotal());
			System.out.println("Funcionário: " + venda.getFuncionario().getPessoa().getNome());
			System.out.println();

		}
	}

	@Test
	@Ignore
	public void consultar() {
		Long ven = 2L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.consultar(ven);

		System.out.println();
		System.out.println("Código: " + venda.getCodigo());
		System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
		System.out.println("Horário: " + venda.getHorario());
		System.out.println("Valor Total R$: " + venda.getValorTotal());
		System.out.println("Funcionário: " + venda.getFuncionario().getPessoa().getNome());
		System.out.println();

	}

	@Test
	@Ignore
	public void excluir() {
		Long ven = 5L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.consultar(ven);
		vendaDao.excluir(venda);
	}

	@Test
	@Ignore
	public void editar() {
		Long vend = 3L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.consultar(vend);
		
		Long cli = 1L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.consultar(cli);
		venda.setCliente(cliente);
		
		Long fun = 1L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.consultar(fun);
		venda.setFuncionario(funcionario);
		
		venda.setHorario(new Date());
		venda.setValorTotal(new BigDecimal("256.52"));
		
		
		vendaDao.editar(venda);
	}

}
