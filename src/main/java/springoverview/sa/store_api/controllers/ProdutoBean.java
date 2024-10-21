package springoverview.sa.store_api.controllers;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
@Component
public class ProdutoBean {
	private Map<Long , Produto> mapaControl = new HashMap<>();
	
	public Produto buscarProduto(long idProduct) {
		return mapaControl.get(idProduct);
	}
	public Produto buscarProduto2(Long id) {
		return mapaControl.get(id);
	}
	
	public Produto atualizarFlagPromocao(Long id, Boolean emPromocao) {
		Produto produto = mapaControl.get(id);
		if (produto != null) {
			produto.setEmPromocao(emPromocao);
		}
		return produto;
	}

	public Produto adicionarAtualizarProduto(Produto produto) {
		mapaControl.put(produto.getIdProduct(),produto);
		return produto;
	}
	
	public Produto atualizarFlagVendido(Long id, Boolean prodVendido) {
		Produto produto = mapaControl.get(id);
		if (produto != null) {
			produto.setVendido(prodVendido);
		}
		return produto;
	}
	
	public Map<Long, Produto> getMapaControl(){
		return mapaControl;
	}
}
