package br.com.leandro.varejao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@SuppressWarnings("serial")
@Entity
public class Fornecedor extends GenericEntity {

	@Column(length = 80, nullable = false)
	private String razaoSocial;

	@Column(length = 30, unique = true)
	private String cnpj;

	@Column(length = 80)
	private String nomeFantasia;

	@Column(length = 30)
	private String inscricaoEstadual;

	@Column(length = 70)
	private String representante;

	@Column(length = 20)
	private String telefone;

	@Column(length = 20)
	private String celular;

	@Column(length = 80, unique = true)
	private String email;

	@OneToOne
	@JoinColumn(nullable = false)
	private Endereco endereco;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
