package springoverview.sa.store_api.controllers;

public class Produto {

	private long IdProduct;
	private float producValue;
	private String nameProduct;
	private String producDescrpit;
	private Boolean emPromocao; //flag de bolean
	
	@Override
	public String toString() {
		return "Produto [IdProduct=" + IdProduct + ", producValue=" + producValue + ", nameProduct=" + nameProduct
				+ ", producDescrpit=" + producDescrpit + "]";
	}
	public long getIdProduct() {
		return IdProduct;
	}
	public void setIdProduct(int IdProduct) {
		this.IdProduct = IdProduct;
	}
	public float getProducValue() {
		return producValue;
	}
	public void setProducValue(int producValue) {
		this.producValue = producValue;
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
    public Boolean getEmPromocao() {
        return emPromocao;
    }
    public void setEmPromocao(Boolean emPromocao) {
        this.emPromocao = emPromocao;
    }
	
}
