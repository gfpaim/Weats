package br.ucsal.model;

import java.util.List;

public class Licitacao {

	private int id;
	private String descricao;
	private String data_inicio;
	private String data_fim;
	private String observacoes;
	private List<ItemCotacao> itens_cotacao;
	private Usuario cliente;

	public Usuario getCliente() {
		return cliente;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public List<ItemCotacao> getItens_cotacao() {
		return itens_cotacao;
	}

	public void setItens_cotacao(List<ItemCotacao> itens_cotacao) {
		this.itens_cotacao = itens_cotacao;
	}

}
