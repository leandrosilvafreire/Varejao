package br.com.leandro.varejao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.leandro.varejao.dao.EstadoDao;
import br.com.leandro.varejao.entity.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void novo() {
		estado = new Estado();

	}

	public void salvar() {

		try {
			EstadoDao estadoDao = new EstadoDao();
			estadoDao.salvar(estado);

			novo();

			// Utilizando o Ominfaces
			Messages.addGlobalInfo("Estado salvo com sucesso!");

			// String mensagem = "Leandro";
			// FacesMessage message = new
			// FacesMessage(FacesMessage.SEVERITY_INFO,
			// mensagem, mensagem);
			//
			//
			// FacesContext context = FacesContext.getCurrentInstance();
			// context.addMessage(null, message);

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o estado!");
			erro.printStackTrace();
		}
	}

	@PostConstruct//Construtor
	public void listar() {
		try {

			EstadoDao estadoDao = new EstadoDao();
			estados = estadoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados!");
			erro.printStackTrace();

		}
	}

}
