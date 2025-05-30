package curso.spring.com.produtosapi.repository;

import curso.spring.com.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByName(String nome);
}
