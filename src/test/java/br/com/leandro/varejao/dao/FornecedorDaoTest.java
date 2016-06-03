package br.com.leandro.varejao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Endereco;
import br.com.leandro.varejao.entity.Fornecedor;

public class FornecedorDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setCelular("(16)9.9999-5263");
		fornecedor.setCnpj("26.120.987/0001-42");
		fornecedor.setEmail("Jeanfilhos1@.com");

		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = enderecoDao.consultar(5L);
		fornecedor.setEndereco(endereco);

		fornecedor.setInscricaoEstadual("256.741.785.489");
		fornecedor.setNomeFantasia("Jean e Filhos");
		fornecedor.setRazaoSocial("Jean Filhos Atacado de Frutas e Verduras Ltda");
		fornecedor.setRepresentante("Jean Carlos dos Santos");
		fornecedor.setTelefone("(16)3728-9652");

		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.salvar(fornecedor);

	}

	@Test
	@Ignore
	public void listar() {
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> fornecedores = fornecedorDao.listar();

		for (Fornecedor fornecedor : fornecedores) {

			System.out.println();
			System.out.println("Código: " + fornecedor.getCodigo());
			System.out.println("Razão Social: " + fornecedor.getRazaoSocial());
			System.out.println("Cnpj: " + fornecedor.getCnpj());
			System.out.println("Nome Fantasia: " + fornecedor.getNomeFantasia());
			System.out.println("Inscrição Estadual: " + fornecedor.getInscricaoEstadual());
			System.out.println("Representante: " + fornecedor.getRepresentante());
			System.out.println("Telefone: " + fornecedor.getTelefone());
			System.out.println("celular: " + fornecedor.getCelular());
			System.out.println("Endereço: " + fornecedor.getEndereco().getRua() + " "
					+ fornecedor.getEndereco().getNumero() + " " + fornecedor.getEndereco().getCidade().getNome());
			System.out.println("E-mail: " + fornecedor.getEmail());
			System.out.println();
		}

	}

	@Test
	@Ignore
	public void consulta() {
		Long codigo = 4L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.consultar(codigo);

		System.out.println();
		System.out.println("Código: " + fornecedor.getCodigo());
		System.out.println("Razão Social: " + fornecedor.getRazaoSocial());
		System.out.println("Cnpj: " + fornecedor.getCnpj());
		System.out.println("Nome Fantasia: " + fornecedor.getNomeFantasia());
		System.out.println("Inscrição Estadual: " + fornecedor.getInscricaoEstadual());
		System.out.println("Representante: " + fornecedor.getRepresentante());
		System.out.println("Telefone: " + fornecedor.getTelefone());
		System.out.println("celular: " + fornecedor.getCelular());
		System.out.println("Endereço: " + fornecedor.getEndereco().getRua() + " " + fornecedor.getEndereco().getNumero()
				+ " " + fornecedor.getEndereco().getCidade().getNome());
		System.out.println("E-mail: " + fornecedor.getEmail());
		System.out.println();

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.consultar(codigo);
		fornecedorDao.excluir(fornecedor);

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 7L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.consultar(codigo);

		fornecedor.setCelular("(37)9.8252-5241");
		fornecedor.setCnpj("10.236.784/0001-52");
		fornecedor.setEmail("tresirmaos@outlook.com");

		Long ende = 4L;
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = enderecoDao.consultar(ende);
		fornecedor.setEndereco(endereco);

		fornecedor.setInscricaoEstadual("125.674.410.178");
		fornecedor.setNomeFantasia("Atacado 3 Irmãos");
		fornecedor.setRazaoSocial("Atacado 3 Irmãos Ltda");
		fornecedor.setRepresentante("Luis Cláudio Amaral");
		fornecedor.setTelefone("(37)4512-7412");

		fornecedorDao.editar(fornecedor);

	}

}
