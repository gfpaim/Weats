package br.ucsal.model;

import java.util.List;

public class Cotacao {

	private int id;
	private String descricao;
	private String data_inicio;
	private String data_fim;
	private List<ItemCotacao> itens_cotacao;
	private Cliente cliente;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
