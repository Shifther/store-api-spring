package springoverview.sa.store_api.funcions;

public class Produto {
	
	private int quantidade;
	private long IdProduct;
	private float produtoValor;
	private String nameProduct;
	private String descricaoProduto;
	private Boolean emPromocao; //flag de bolean
	private Boolean prodVendido;
	private Boolean Vendido;	
	
	
	public Boolean isVendido() {
        return Vendido;
    }
	public float getProdutoValor() {
		return produtoValor;
	}
	public Boolean getVendido() {
		return Vendido;
	}
	public void setVendido(Boolean vendido) {
		Vendido = vendido;
	}
	public void setProdutoValor(float produtoValor) {
		this.produtoValor = produtoValor;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public Boolean getProdVendido() {
		return prodVendido;
	}
	public void setProdVendido(Boolean prodVendido) {
		this.prodVendido = prodVendido;
	}	
	
	public long getIdProduct() {
		return IdProduct;
	}
	public void setIdProduct(long IdProduct) {
		this.IdProduct = IdProduct;
	}
	public float getprodutoValor() {
		return produtoValor;
	}
	public void setprodutoValor(int produtoValor) {
		this.produtoValor = produtoValor;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getdescricaoProduto() {
		return descricaoProduto;
	}
	public void setdescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
    public Boolean getEmPromocao() {
        return emPromocao;
    }
    public void setEmPromocao(Boolean emPromocao) {
        this.emPromocao = emPromocao;
    }	
	
	public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
    	if(quantidade < 0) {
    		throw new IllegalArgumentException("A quantidade não pode ser negativa.");
    	}
        this.quantidade = quantidade;
    }

	
}
