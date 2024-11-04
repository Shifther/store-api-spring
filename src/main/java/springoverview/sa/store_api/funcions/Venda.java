package springoverview.sa.store_api.funcions;

public class Venda {
	
	private boolean prodVendido;
    private int quantidade; // Quantidade a ser vendida

    // Getters e Setters
    public boolean isProdVendido() {
        return prodVendido;
    }

    public void setProdVendido(boolean prodVendido) {
        this.prodVendido = prodVendido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public boolean isVendido() {
		return this.prodVendido;
	}
	public void setVendido(Boolean prodVendido) {
		this.prodVendido = prodVendido;
	}
	
	public void getProdVendido(boolean prodVendido) {
		this.prodVendido = prodVendido;
	}
	
	
}
