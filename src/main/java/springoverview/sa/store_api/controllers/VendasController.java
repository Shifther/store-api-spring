package springoverview.sa.store_api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    

	@PutMapping("/{id}/vendido")
	public ResponseEntity<Produto> atualizarVenda(@PathVariable Long id, @RequestParam Boolean prodVendido) {
	    Produto produtoAtualizado = produtoBean.atualizarFlagVendido(id, prodVendido);
	    if (produtoAtualizado != null) {
	        produtoAtualizado.setVendido(prodVendido);
	        return ResponseEntity.ok(produtoAtualizado);
	    } else 
	        return ResponseEntity.notFound().build();
	}
	
	
}
