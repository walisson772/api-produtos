package curso.spring.com.produtosapi.controller;

import curso.spring.com.produtosapi.model.Produto;
import curso.spring.com.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome ){
        return repository.findByName(nome);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable String id){
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        repository.deleteById(id);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        repository.save(produto);
        return produto;
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Produto produto){
        produto.setId(id);
        repository.save(produto);
    }
}
