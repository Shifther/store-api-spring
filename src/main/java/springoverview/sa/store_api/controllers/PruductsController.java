package springoverview.sa.store_api.controllers;

import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("produtos")
@CrossOrigin(origins = "*")

public class PruductsController {
	
    @Autowired
    private ProdutoBean produtoBean; 
	
	int counter = 0;
	@PostMapping("new")
	public Produto newProd (@RequestBody Produto produto) {		
		produto.setIdProduct(counter++);
		produto.setNameProduct(produto.getNameProduct()+" "+counter);
		produto.setProducDescrpit(produto.getProducDescrpit()+" "+counter);
//		produtoBean.getMapaControl.put(produto.getIdProduct(), produto);
		produtoBean.adicionarAtualizarProduto(produto);
//		System.out.println(produtoBean.getMapaControl());	
		return produto;
	}	
	
	@GetMapping("productlist")
	public List<Produto> listProduto (){
		return produtoBean.getMapaControl().entrySet().stream().map(e -> e.getValue()).toList();
	}
	
	@GetMapping("searchbyid")
	public Produto serchID(@RequestParam Integer IdProduct){
		Produto produto = produtoBean.buscarProduto((long)IdProduct);		
		return produto;
	}

	@DeleteMapping("delbyid/{id}")
	public Produto deletebyID(@PathVariable long id) {
		Produto produto = produtoBean.getMapaControl().remove(id);
		return produto;
	}	
	
	@PutMapping("updateproduct/{id}")
	public Produto attProduct (@PathVariable Integer id, @RequestBody Produto produto) {
		Produto produtoFound = produtoBean.buscarProduto(id);
		if (produtoFound != null) {
		    produto.setIdProduct(id.intValue());
			produtoBean.adicionarAtualizarProduto(produto);
			return produto;
		}return null;
	}
}
