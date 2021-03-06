package br.ucsal.model;

import java.util.List;

public class Orcamento {
	private int id;
	private String descricao;
	private double valor;
	private Licitacao licitacao;
	private List<ItemCotacao> intens_cotacao;
	private String prazo;
	private String validade;
	private Usuario fornecedor;

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Licitacao getLicitacao() {
		return licitacao;
	}

	public void setLicitacao(Licitacao cotacao) {
		this.licitacao = cotacao;
	}

	public List<ItemCotacao> getIntens_cotacao() {
		return intens_cotacao;
	}

	public void setIntens_cotacao(List<ItemCotacao> intens_cotacao) {
		this.intens_cotacao = intens_cotacao;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public Usuario getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Usuario fornecedor) {
		this.fornecedor = fornecedor;
	}

}
