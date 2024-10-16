package springoverview.sa.store_api.controllers;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("produtos")
@CrossOrigin(origins = "*")

public class PruductsCrontoller {
	int counter = 0;
	@PostMapping("new")
	public Produto newProd (@RequestBody Produto produto) {		
		produto.setIdClient(counter++);
		System.out.println(produto);
		return produto;
	}	
	
}
