package springoverview.sa.store_api.models;

import java.util.List;

public class Venda {
	
	private Long idVenda;
    private List<Produto> produtos;
    private Double valorTotal;
    private Boolean vendaFinalizada; // Quantidade a ser vendida
    private int quantidade;

    // Getters e Setters
    
    public boolean isProdVendido() {
		// TODO Auto-generated method stub
		return false;
	}
    
    public Long getIdVenda() {
        return idVenda;
    }
    
    public int getQuantidade() {
    	return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getVendaFinalizada() {
        return vendaFinalizada;
    }

    public void setVendaFinalizada(Boolean vendaFinalizada) {
        this.vendaFinalizada = vendaFinalizada;
    }

    // Método para calcular o valor total da venda
    public void calcularValorTotal() {
        this.valorTotal = produtos.stream()
                                   .mapToDouble(Produto::getProducValue)
                                   .sum();
    }

	
	
}
