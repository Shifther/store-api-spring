package springoverview.sa.store_api.models;

public class Produto {
	

	private Long idProduct;
    private String nameProduct;
    private String producDescrpit;
    private Double producValue;
    private Boolean emPromocao;
    private Boolean prodVendido;
	private int quantidade;
	private boolean vendido;
	@Override
	public String toString() {
		return "Produto [IdProduct= " + idProduct + ", producValue= " + producValue + ", nameProduct= " + nameProduct
				+ ", producDescrpit= " + producDescrpit + ", emPromocao = " + emPromocao + ", vendido = " + prodVendido + "]";
	}
	
	public boolean isVendido() {
        return vendido;
    }
	
	public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProducDescrpit() {
        return producDescrpit;
    }

    public void setProducDescrpit(String producDescrpit) {
        this.producDescrpit = producDescrpit;
    }

    public Double getProducValue() {
        return producValue;
    }

    public void setProducValue(Double producValue) {
        this.producValue = producValue;
    }

    public Boolean getEmPromocao() {
        return emPromocao;
    }

    public void setEmPromocao(Boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    public Boolean getProdVendido() {
        return prodVendido;
    }

    public void setProdVendido(Boolean prodVendido) {
        this.prodVendido = prodVendido;
    }
	
}
