package springoverview.sa.store_api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("promocoes")
@CrossOrigin(origins = "*")
@RequestScope
public class promocoes {

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
		return List.of(("Promoções do dia %s \nCelular por : " + valorCel),LocalDate.now().toString());
	}
	
}
