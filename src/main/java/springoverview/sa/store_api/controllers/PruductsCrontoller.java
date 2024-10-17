package springoverview.sa.store_api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;


@RestController
@RequestMapping("produtos")
@CrossOrigin(origins = "*")

public class PruductsCrontoller {
	int counter = 0;
	@PostMapping("new")
	public Produto newProd (@RequestBody Produto produto) {		
		produto.setIdProduct(counter++);
		produto.setNameProduct(produto.getNameProduct()+counter);
		produto.setProducDescrpit(produto.getProducDescrpit()+counter);
		mapaControl.put(produto.getIdProduct(), produto);
		System.out.println(mapaControl);
		return produto;
	}	
	
	@GetMapping("productlist")
	public List<Produto> listProduto (){
		return mapaControl.entrySet().stream().map(e -> e.getValue()).toList();
	}
	
	@GetMapping("serchbyid")
	public Produto serchID(@RequestParam Integer iDProd){
		Produto produto = mapaControl.get(iDProd);		
		return produto;
	}
	
	Map < Integer, Produto > mapaControl = new HashMap<>();
	
	@DeleteMapping("delbyid/{id}")
	public Produto deletebyID(@PathVariable Integer id) {
		Produto produto = mapaControl.remove(id);
		return produto;
	}	
	
	@PutMapping("updateproduct/{id}")
	public Produto attProduct (@PathVariable Integer id, @RequestBody Produto produto) {
		Produto produtoFound = mapaControl.get(id);
		if (produtoFound != null) {
		    produto.setIdProduct(id);
			mapaControl.put(id, produto);
			return produto;
		}return null;
	}
}
