package br.ucsal.model;

import java.util.List;

public class Cliente {
	private int id;
	private String cnpj;
	private String cpf;
	private int usuario;
	private List<Licitacao> cotacoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public List<Licitacao> getCotacoes() {
		return cotacoes;
	}

	public void setCotacoes(List<Licitacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

}
