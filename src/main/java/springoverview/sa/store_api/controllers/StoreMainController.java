package springoverview.sa.store_api.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import springoverview.sa.store_api.funcions.Produto;
import springoverview.sa.store_api.funcions.ProdutoBean;

@RestController
@RequestMapping("store")
@CrossOrigin(origins = "*")
@RequestScope
public class StoreMainController {

	private final static String WELCOME_MSG = "Welcome to Spring Store";
	
	@Autowired
	private ProdutoBean produtoBean; 
	
	@Autowired
	@Qualifier("getlocalDateTime")
	private LocalDateTime localDateTime; 
	
	@Autowired
	@Qualifier("initialLocalDate")
	private LocalDateTime timeActual;
	
	@GetMapping("welcome")
	public String welcome(@RequestParam String userName) {
		return WELCOME_MSG + " " + userName + "!";
	}

	@GetMapping("date")
	public String currentDate() {
		return LocalDate.now().toString();
	}

	@GetMapping("home")
	public String home() {
		return String.format("%s today is %s", WELCOME_MSG, LocalDate.now().toString());
	}
	
	
	@GetMapping("listar-compras-periodo")
	public List<String> comprasDoPeriodo(@RequestParam String initDate, @RequestParam String endDate ){
		
		System.out.println(initDate);
		System.out.println(endDate);
		
		return List.of("Celular", "Ferro de passar", "Cama");
	}
	
	
	@GetMapping("horaatual")
	public LocalDateTime initiDate(){
		return localDateTime;
	}
	
	@GetMapping("horafixa")
	public LocalDateTime timeActual() {
		return timeActual;
	}
	
	@GetMapping("avenda")
	public ResponseEntity<List<Produto>> listVendas() {
	    List<Produto> produtosVendidos = produtoBean.getMapaControl().values().stream()
	            .filter(Produto::isVendido) // Filtra produtos que foram vendidos
	            .collect(Collectors.toList());
	    return ResponseEntity.ok(produtosVendidos);
	}
    
	@PostMapping("/products/{id}/comprar")
	public ResponseEntity<String> comprarProduto(@PathVariable long idProduct, @RequestParam int quantidade) {
		ResponseEntity<String> response = produtoBean.comprarProduto(idProduct, quantidade);
		return response;
	}
	
    @PostMapping("/products/{id}/vendido")
    public String marcarComoVendido(@PathVariable long id) {
        Produto produto = produtoBean.atualizarFlagVendido(id, true); // Marca como vendido
        if (produto != null) {
            return "Produto " + produto.getNameProduct() + " foi marcado como vendido.";
        }
        return "Produto não encontrado.";
    }
}
