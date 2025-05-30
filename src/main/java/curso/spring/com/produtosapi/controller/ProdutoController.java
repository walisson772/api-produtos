package curso.spring.com.produtosapi.controller;

import curso.spring.com.produtosapi.model.Produto;
import curso.spring.com.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar(){
        List<Produto> list = repository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable String id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Produto salver(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        repository.save(produto);
        return produto;
    }
}
