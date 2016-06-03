package br.com.leandro.varejao.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.leandro.varejao.entity.Item;
import br.com.leandro.varejao.entity.Produto;
import br.com.leandro.varejao.entity.Venda;

public class ItemDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Item item = new Item();

		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultar(4L);
		item.setProduto(produto);

		item.setQuantidade(new Short("5"));
		item.setValorParcial(new BigDecimal("6.87"));

		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.consultar(5L);
		item.setVenda(venda);

		ItemVendaDao itemVendaDao = new ItemVendaDao();
		itemVendaDao.salvar(item);

	}

	@Test
	@Ignore
	public void listar() {

		ItemVendaDao itemVendaDao = new ItemVendaDao();
		List<Item> lista = itemVendaDao.listar();

		for (Item item : lista) {

			System.out.println();
			System.out.println("Código: " + item.getCodigo());
			System.out.println("Produto: " + item.getProduto().getNome());
			System.out.println("Quantidade: " + item.getQuantidade());
			System.out.println("Valor Parcial: R$" + item.getValorParcial());
			System.out.println("Valor Total: R$" + item.getVenda().getValorTotal());
			System.out.println();

		}

	}

	@Test
	@Ignore
	public void consultar() {
		Long it = 2L;
		ItemVendaDao itemVendaDao = new ItemVendaDao();
		Item item = itemVendaDao.consultar(it);

		System.out.println();
		System.out.println("Código: " + item.getCodigo());
		System.out.println("Produto: " + item.getProduto().getNome());
		System.out.println("Quantidade: " + item.getQuantidade());
		System.out.println("Valor Parcial: R$" + item.getValorParcial());
		System.out.println("Valor Total: R$" + item.getVenda().getValorTotal());
		System.out.println();
	}

	@Test
	@Ignore
	public void excluir() {
		Long it = 4L;
		ItemVendaDao itemVendaDao = new ItemVendaDao();
		Item item = itemVendaDao.consultar(it);
		itemVendaDao.excluir(item);

	}

	@Test
	@Ignore
	public void editar() {
		Long it = 2L;
		ItemVendaDao itemVendaDao = new ItemVendaDao();
		Item item = itemVendaDao.consultar(it);

		Long pro = 1L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultar(pro);
		item.setProduto(produto);

		item.setQuantidade(new Short("5"));
		item.setValorParcial(new BigDecimal("25.63"));

		Long ven = 3L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.consultar(ven);
		item.setVenda(venda);

		itemVendaDao.editar(item);
	}

}
