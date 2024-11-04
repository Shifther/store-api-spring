package springoverview.sa.store_api.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springoverview.sa.store_api.models.Produto;
import springoverview.sa.store_api.objects.ProdutoBean;

@RestController
@RequestMapping("promocoes")
@CrossOrigin(origins = "*")
public class PromocoesController {
	
	@Autowired
	private ProdutoBean produtoBean;
	
	private final static String welcome = "Promotions for today!";
	@GetMapping("welcome")
	public String welcome(@RequestParam String userName) {
		return welcome + " " + userName + "!";
	}
	
	@GetMapping("promoday")
	public List<String> comprasDoDia(@RequestParam String initDate , @RequestParam String endDate){
		
		System.out.println(initDate);
		System.out.println(endDate);
		int valorCel = 175;
		int valorTorradeira = 76;
		int valorComp = 90;
		return List.of("Promoções do dia " + LocalDate.now().toString(),"Celular : $" +valorCel, "Torradeira : $" +valorTorradeira , "Computador : $" +valorComp);
	}
	
	@GetMapping("lista")
	public ResponseEntity<List<Produto>> listPromo() {
		List<Produto> produtosEmPromocao = produtoBean.getMapaControl().values().stream()
			    .filter(Produto::getEmPromocao)
			    .collect(Collectors.toList());
	    return ResponseEntity.ok(produtosEmPromocao);
	}    
	    
		@PutMapping("/{id}/promocao")
		public ResponseEntity<Produto> atualizarPromo(@PathVariable Long id, @RequestParam Boolean emPromocao) {
		    Produto produtoAtualizado = produtoBean.atualizarFlagPromocao(id, emPromocao);
		    if (produtoAtualizado != null) {
		        produtoAtualizado.setEmPromocao(emPromocao);
		        return ResponseEntity.ok(produtoAtualizado);
		    } else 
		        return ResponseEntity.notFound().build();
		}
		
	    @PostMapping("/")
	    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
	        try {
	        	Produto produtoSalvo = produtoBean.adicionarProduto(produto);
	        	return ResponseEntity.ok(produtoSalvo);
	        }
	        catch(IllegalArgumentException e){        
	        	return ResponseEntity.badRequest().body(null);
	        }
	 }   
}
