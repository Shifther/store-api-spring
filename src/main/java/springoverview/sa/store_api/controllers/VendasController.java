package springoverview.sa.store_api.controllers;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springoverview.sa.store_api.models.Produto;
import springoverview.sa.store_api.models.Venda;
import springoverview.sa.store_api.objects.ProdutoBean;

@RestController
@RequestMapping("vendas")
@CrossOrigin(origins = "*")
public class VendasController {
	
    @Autowired
    private ProdutoBean produtoBean; 
    
    @Operation(summary = "Listar produtos vendidos", description = "Retorna uma lista de produtos que foram vendidos.")
	@GetMapping("lista")
	public ResponseEntity<List<Produto>> listVendas() {
        List<Produto> produtosVendidos = produtoBean.getMapaControl().values().stream()
                .filter(Produto::isVendido)
                .collect(Collectors.toList());
        return ResponseEntity.ok(produtosVendidos);
    }
    

	
    @Operation(summary = "Atualizar venda", description = "Atualiza a venda de um produto específico.")
    @ApiResponse(responseCode = "200", description = "Venda atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro ao atualizar venda")
    @PutMapping("atualizar/{id}")
	public ResponseEntity<Produto> atualizarVenda(@PathVariable Long IdProduct, @RequestBody Venda request) {
	    Produto produto = produtoBean.buscarProduto(IdProduct); // Busca o produto diretamente
	    if (produto == null) {
	        return ResponseEntity.notFound().build(); // Produto não encontrado
	    }
	    
	    int quantidade = request.getQuantidade(); // Se a quantidade vier do request, pode ser útil

	    if (!request.isProdVendido() || quantidade <= 0 || quantidade > produto.getQuantidade()) {
	        return ResponseEntity.badRequest().body(null); // Validação
	    }

	    try {
	        Produto produtoAtualizado = produtoBean.venderProduto(IdProduct, quantidade);
	        return ResponseEntity.ok(produtoAtualizado);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(null);
	    }
	}
}
