package springoverview.sa.store_api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springoverview.sa.store_api.funcions.Produto;
import springoverview.sa.store_api.funcions.ProdutoBean;
import springoverview.sa.store_api.funcions.Venda;

@RestController
@RequestMapping("vendas")
@CrossOrigin(origins = "*")

public class VendasController {
	
    @Autowired
    private ProdutoBean produtoBean; 
    
	@GetMapping("lista")
	public ResponseEntity<List<Produto>> listVendas() {
		List<Produto> produtosVendidos  = produtoBean.getMapaControl().values().stream()
			    .filter(Produto::isVendido)
			    .collect(Collectors.toList());
	    return ResponseEntity.ok(produtosVendidos);
	} 
    

	@PutMapping("atualizar/{id}")
	public ResponseEntity<Produto> atualizarVenda(@PathVariable Long IdProduct, @RequestBody Venda request) {
	    if (!request.isProdVendido()) {	    
	        return ResponseEntity.badRequest().body(null);
	    }
	    int quantidade = request.getQuantidade();
	    try {
	    	Produto produtoAtualizado = produtoBean.venderProduto(IdProduct, quantidade);
	    	return ResponseEntity.ok(produtoAtualizado);
	    }catch(IllegalArgumentException e) {
	    	return ResponseEntity.badRequest().body(null);
	    }
	}
}
