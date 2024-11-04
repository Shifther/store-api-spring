package springoverview.sa.store_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import springoverview.sa.store_api.funcions.Produto;
import springoverview.sa.store_api.funcions.ProdutoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("produtos")
@CrossOrigin(origins = "*")

public class PruductsController {
	
    @Autowired
    private ProdutoBean produtoBean; 
	
	
	@PostMapping("new")
	public ResponseEntity<Produto> newProd (@RequestBody Produto produto) {				
		if (produto.getIdProduct() == -1) {
			produto.setIdProduct(System.currentTimeMillis());
		}		
		produtoBean.adicionarAtualizarProduto(produto);
	    return ResponseEntity.ok(produto);
	}	
	
	@GetMapping("productlist")
	public List<Produto> listProduto (){
		return produtoBean.getMapaControl().values().stream().toList();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> serchID(@PathVariable long IdProduct) {
	    Produto produto = produtoBean.buscarProduto(IdProduct);
	    if (produto == null) {
	        // Retorna 404 Not Found se o produto não existir
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna null para o corpo
	    }
	    return ResponseEntity.ok(produto); // Retorna o produto encontrado
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletebyID(@PathVariable long IdProduct) {
		Produto produto = produtoBean.buscarProduto(IdProduct);
		if (produto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
		}
		produtoBean.removerProduto(IdProduct);
		return ResponseEntity.ok("Produto deletado com sucesso.");
	}	
	
	@PutMapping("update/{id}")
	public ResponseEntity<Produto> updateProduct (@PathVariable Integer id, @RequestBody Produto produto) {
		Produto produtoFound = produtoBean.buscarProduto(id);		
		if (produtoFound == null) {
		    return ResponseEntity.notFound().build();
		}	
		produtoBean.adicionarAtualizarProduto(produto);
		return ResponseEntity.ok(produto);
	}
}
