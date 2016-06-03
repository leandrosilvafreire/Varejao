package br.com.leandro.varejao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leandro.varejao.entity.Pessoa;
import br.com.leandro.varejao.entity.Usuario;

public class UsuarioDaotest {

	@Test
	@Ignore
	public void salvar() {
		Usuario usuario = new Usuario();

		usuario.setAtivo(true);

		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(6L);
		usuario.setPessoa(pessoa);

		usuario.setSenha("popdd");
		usuario.setTipo('G');

		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);

	}

	@Test
	@Ignore
	public void listar() {

		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> lista = usuarioDao.listar();

		for (Usuario usuario : lista) {

			System.out.println();
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Nome: " + usuario.getPessoa().getNome());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println();

		}

	}

	@Test
	@Ignore
	public void consultar() {
		Long usu = 2L;
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.consultar(usu);

		System.out.println();
		System.out.println("Código: " + usuario.getCodigo());
		System.out.println("Nome: " + usuario.getPessoa().getNome());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Ativo: " + usuario.getAtivo());
		System.out.println();

	}
	
	@Test
	@Ignore
	public void excluir(){
		Long usu = 4L;
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.consultar(usu);
		usuarioDao.excluir(usuario);
	}
	
	@Test
	@Ignore
	public void editar(){
		Long usu = 5L;
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.consultar(usu);
		
		usuario.setAtivo(false);
		
		Long pess = 4L;
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.consultar(pess);
		usuario.setPessoa(pessoa);
		
		usuario.setSenha("113748");
		usuario.setTipo('A');
		
		usuarioDao.editar(usuario);
		
	}

}
