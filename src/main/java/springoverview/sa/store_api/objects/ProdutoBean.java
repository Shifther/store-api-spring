package springoverview.sa.store_api.objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import springoverview.sa.store_api.models.Produto;
import springoverview.sa.store_api.models.Venda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProdutoBean {
	private Map<Long , Produto> mapaControl = new HashMap<>();
	private Map<Long , Venda> vendas = new HashMap<>();
	
	public Produto buscarProduto(long idProduct) {
		return mapaControl.get(idProduct);
	}
	
	public Produto adicionarProduto(Produto produto) {
		if (mapaControl.containsKey(produto.getIdProduct())) {
			throw new IllegalArgumentException("Produto já existe com este ID: " + produto.getIdProduct());
		}
		mapaControl.put(produto.getIdProduct(), produto);
		return produto;
    }
	
	public Produto atualizarProduto(Produto produto) {
		if (!mapaControl.containsKey(produto.getIdProduct())) {
			throw new IllegalArgumentException("Produto não encontrado com este ID: " + produto.getIdProduct());
		}
		mapaControl.put(produto.getIdProduct(), produto);
		return produto;
    }
	
	public void removerProduto(long idProduct) {
	    mapaControl.remove(idProduct);
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
	        
	        // Criar uma nova venda após a compra
	        Venda venda = new Venda();
	        venda.setIdVenda(System.currentTimeMillis()); // Exemplo de geração de ID para a venda
	        venda.setProdutos(List.of(produto)); // Adiciona o produto à venda
	        venda.calcularValorTotal(); // Calcula o valor total da venda
	        vendas.put(venda.getIdVenda(), venda); // Armazena a venda
	        
	        return ResponseEntity.ok("Compra realizada com sucesso! Produto: " + produto.getNameProduct() + ", Nova quantidade: " + produto.getQuantidade());
	    }
	//-----------------------------------------------------------------//
	public Produto atualizarFlagVendido(Long id, Boolean prodVendido) {
		Produto produto = mapaControl.get(id);
		if (produto != null) {
			Venda venda = new Venda();
			venda.setVendaFinalizada(prodVendido);
			produto.setProdVendido(prodVendido);
		}
		return produto;
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
			venda.setVendaFinalizada(true);
		}
		return produto;
	}	
	
	public Map<Long, Produto> getMapaControl(){
		return mapaControl;
	}

}
