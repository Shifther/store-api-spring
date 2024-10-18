package springoverview.sa.store_api.controllers;

import java.util.List;

public class Venda {
	
	
	private Integer idVenda;
	private List<Produto> produtos;
	private Double total;
	private String cliente;
	private String data;
	
	public Venda(Integer idVenda, List<Produto> produtos, Double total, String cliente, String data) {
        this.idVenda = idVenda;
        this.produtos = produtos;
        this.total = total;
        this.cliente = cliente;
        this.data = data;
		
	}
	public Integer getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
