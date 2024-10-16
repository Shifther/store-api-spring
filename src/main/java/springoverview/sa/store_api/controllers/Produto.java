package springoverview.sa.store_api.controllers;

import org.springframework.boot.autoconfigure.influx.InfluxDbOkHttpClientBuilderProvider;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Produto {

	private int idClient;
	private float producValue;
	private String nameProduct;
	private String producDescrpit;
	
	@Override
	public String toString() {
		return "Produto [idClient=" + idClient + ", producValue=" + producValue + ", nameProduct=" + nameProduct
				+ ", producDescrpit=" + producDescrpit + "]";
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
	
	
	
}
