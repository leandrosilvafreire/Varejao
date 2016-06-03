package br.com.leandro.varejao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Cidade;
import br.com.leandro.varejao.entity.Endereco;

public class EnderecoDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Endereco endereco = new Endereco();

		endereco.setRua("Rua Altino Arantes");
		endereco.setNumero(1652);
		endereco.setBairro("Vila Virgínia");
		endereco.setComplemento("Fundos casa 3");
		endereco.setCep("15.652-85");

		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.consultar(2L);
		endereco.setCidade(cidade);

		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.salvar(endereco);

	}

	@Test
	@Ignore
	public void listar() {

		EnderecoDao enderecoDao = new EnderecoDao();
		List<Endereco> enderecos = enderecoDao.listar();

		for (Endereco endereco : enderecos) {

			System.out.println();
			System.out.println("Código: " + endereco.getCodigo());
			System.out.println("Logradouro: " + endereco.getRua());
			System.out.println("Número: " + endereco.getNumero());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("Complemento: " + endereco.getComplemento());
			System.out.println("Cep: " + endereco.getCep());
			System.out.println("Cidade: " + endereco.getCidade().getNome());
			System.out.println();

		}

	}

	@Test
	@Ignore
	public void consulta() {
		Long codigo = 8L;
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = enderecoDao.consultar(codigo);

		System.out.println();
		System.out.println("Código: " + endereco.getCodigo());
		System.out.println("Logradouro: " + endereco.getRua());
		System.out.println("Número: " + endereco.getNumero());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Complemento: " + endereco.getComplemento());
		System.out.println("Cep: " + endereco.getCep());
		System.out.println("Cidade: " + endereco.getCidade().getNome());
		System.out.println();

	}
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 5L;
		EnderecoDao enderecoDao =  new EnderecoDao();
		Endereco endereco = enderecoDao.consultar(codigo);
		enderecoDao.excluir(endereco);
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 3L;
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = enderecoDao.consultar(codigo);
		
		endereco.setRua("AV  Treze de Maio");
		endereco.setNumero(526);
		endereco.setBairro("Centro");
		endereco.setComplemento("Fundos");
		endereco.setCep("15.856-095");
		
		Long cid = 8L;
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.consultar(cid);
		endereco.setCidade(cidade);
		
		enderecoDao.editar(endereco);
		
				
		
		
	}

}
