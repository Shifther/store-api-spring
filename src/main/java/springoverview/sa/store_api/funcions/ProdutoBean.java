package springoverview.sa.store_api.funcions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

@Component
public class ProdutoBean {
	private Map<Long , Produto> mapaControl = new HashMap<>();
	
	public Produto buscarProduto(long idProduct) {
		return mapaControl.get(idProduct);
	}	
	
	public Produto adicionarAtualizarProduto(Produto produto) {
		if (mapaControl.containsKey(produto.getIdProduct())) {
			mapaControl.put(produto.getIdProduct(), produto);
			throw new IllegalArgumentException("Produto já existe com este ID: " + produto.getIdProduct());
		}else {
		mapaControl.put(produto.getIdProduct(),produto);
		}
		return produto;
	}
	
	public Produto atualizarFlagVendido(Long id, Boolean prodVendido) {
		Produto produto = mapaControl.get(id);
		if (produto != null) {
			Venda venda = new Venda();
			venda.setVendido(prodVendido);
			produto.setVendido(prodVendido);
		}
		return produto;
	}
	
	public ResponseEntity<String> comprarProduto(Long idProduct, int quantidade) {
	    Produto produto = mapaControl.get(idProduct);
	    
	    if (produto == null) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
	    }
	    if (quantidade <= 0) {
	        return ResponseEntity.badRequest().body("A quantidade deve ser maior que zero.");
	    }
	    if (produto.getQuantidade() < quantidade) {
	    	return ResponseEntity.badRequest().body("Quantidade insuficiente em estoque.");
	    }
	    produto.setQuantidade(produto.getQuantidade() - quantidade);
	    return ResponseEntity.ok("Compra realizada com sucesso! Produto: " + produto.getNameProduct() + ", Nova quantidade: " + produto.getQuantidade());
	}
	public void removerProduto(long idProduct) {
	    mapaControl.remove(idProduct);
	}
	public Produto atualizarFlagPromocao(Long id, Boolean emPromocao) {
		Produto produto = mapaControl.get(id);
		if (produto != null) {
			produto.setEmPromocao(emPromocao);
		}
		return produto;
	}
	
	public Produto venderProduto(Long idProduct, int quantidade) {
		Produto produto = buscarProduto(idProduct);
		Venda venda = new Venda();
		if (produto == null) {
			throw new IllegalArgumentException("Produto nao encontrado.");
		}
		if (quantidade <= 0 || quantidade > produto.getQuantidade()) {
			throw new IllegalArgumentException("Quantidade invalida.");
		}
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		
		if (produto.getQuantidade() == 0) {
			venda.setVendido(true);
		}
		return produto;
	}
	
	
	public Map<Long, Produto> getMapaControl(){
		return mapaControl;
	}
	

}
