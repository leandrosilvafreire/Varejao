package br.com.leandro.varejao.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Fornecedor;
import br.com.leandro.varejao.entity.Produto;

public class ProdutoDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Produto produto = new Produto();
		produto.setNome("Laranja");
		produto.setPreco(new BigDecimal("5.23"));
		produto.setQuantidade(new Short("2"));

		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.consultar(1L);
		produto.setFornecedor(fornecedor);

		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.salvar(produto);

	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDao produtoDao = new ProdutoDao();
		List<Produto> resultado = produtoDao.listar();

		for (Produto produto : resultado) {
			System.out.println();
			System.out.println("Código: " + produto.getCodigo());
			System.out.println("Produto: " + produto.getNome());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("Preço R$ : " + produto.getPreco());
			System.out.println("Fornecedor: " + produto.getFornecedor().getRazaoSocial());
			System.out.println();

		}

	}

	@Test
	@Ignore
	public void consultar() {
		Long codigo = 2L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultar(codigo);

		System.out.println();
		System.out.println("Código: " + produto.getCodigo());
		System.out.println("Produto: " + produto.getNome());
		System.out.println("Quantidade: " + produto.getQuantidade());
		System.out.println("Preço R$ : " + produto.getPreco());
		System.out.println("Fornecedor: " + produto.getFornecedor().getRazaoSocial());
		System.out.println();

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultar(codigo);
		produtoDao.excluir(produto);

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.consultar(codigo);

		produto.setNome("Limão");
		produto.setPreco(new BigDecimal("4.25"));
		produto.setQuantidade(new Short("3"));

		FornecedorDao fornecedorDao = new FornecedorDao();
		//Outra forma de bucar por código
		Fornecedor fornecedor = fornecedorDao.consultar(new Long("7"));
		produto.setFornecedor(fornecedor);

		produtoDao.editar(produto);

	}

}
