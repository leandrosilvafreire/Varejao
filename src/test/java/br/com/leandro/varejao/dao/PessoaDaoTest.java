package br.com.leandro.varejao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Endereco;
import br.com.leandro.varejao.entity.Pessoa;

public class PessoaDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Pessoa pessoa = new Pessoa();

		pessoa.setCelular("(16)9.5614-8596");
		pessoa.setCpf("175.412.320-89");
		pessoa.setEmail("juniormendoca@gmail.com.com");

		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = enderecoDao.consultar(1L);
		pessoa.setEndereco(endereco);

		pessoa.setNome("Junior Mendonça Mendes");
		pessoa.setRg("49.562.123-8");
		pessoa.setTelefone("(16)3724-5263");

		PessoaDao pessoaDao = new PessoaDao();
		pessoaDao.salvar(pessoa);

	}

	@Test
	@Ignore
	public void listar() {
		PessoaDao pessoaDao = new PessoaDao();
		List<Pessoa> lista = pessoaDao.listar();

		for (Pessoa pessoa : lista) {

			System.out.println();
			System.out.println("Código: " + pessoa.getCodigo());
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Rua: " + pessoa.getEndereco().getRua());
			System.out.println("Número: " + pessoa.getEndereco().getNumero());
			System.out.println("Bairro: " + pessoa.getEndereco().getBairro());
			System.out.println("Complemento: " + pessoa.getEndereco().getComplemento());
			System.out.println("Cep: " + pessoa.getEndereco().getCep());
			System.out.println("Cidade: " + pessoa.getEndereco().getCidade().getNome());
			System.out.println("Estado: " + pessoa.getEndereco().getCidade().getEstado().getSigla());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("E-mail: " + pessoa.getEmail());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void consultar() {
		Long resul = 4L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(resul);

		System.out.println();
		System.out.println("Código: " + pessoa.getCodigo());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Rua: " + pessoa.getEndereco().getRua());
		System.out.println("Número: " + pessoa.getEndereco().getNumero());
		System.out.println("Bairro: " + pessoa.getEndereco().getBairro());
		System.out.println("Complemento: " + pessoa.getEndereco().getComplemento());
		System.out.println("Cep: " + pessoa.getEndereco().getCep());
		System.out.println("Cidade: " + pessoa.getEndereco().getCidade().getNome());
		System.out.println("Estado: " + pessoa.getEndereco().getCidade().getEstado().getSigla());
		System.out.println("CPF: " + pessoa.getCpf());
		System.out.println("RG: " + pessoa.getRg());
		System.out.println("Telefone: " + pessoa.getTelefone());
		System.out.println("Celular: " + pessoa.getCelular());
		System.out.println("E-mail: " + pessoa.getEmail());
		System.out.println();

	}

	@Test
	@Ignore
	public void excluir() {
		Long resul = 7L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(resul);

		pessoaDao.excluir(pessoa);

	}

	@Test
	@Ignore
	public void editar() {
		Long resul = 1L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(resul);

		pessoa.setCelular("(16)9.1452-5685");
		pessoa.setCpf("123.856.741-96");
		pessoa.setEmail("hernadesferreira@gamil.com");

		Long ende = 1L;
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = enderecoDao.consultar(ende);
		pessoa.setEndereco(endereco);

		pessoa.setNome("Hernandes Lopes Ferrreira");
		pessoa.setRg("45.784.654-2");
		pessoa.setTelefone("(16)3726-9745");

		pessoaDao.editar(pessoa);

		Long pess = 4L;
		PessoaDao pessoaDao2 = new PessoaDao();
		Pessoa pessoa2 = pessoaDao2.consultar(pess);

		pessoa2.setRg("25.745.412-5");

		pessoaDao2.editar(pessoa2);

	}
}
