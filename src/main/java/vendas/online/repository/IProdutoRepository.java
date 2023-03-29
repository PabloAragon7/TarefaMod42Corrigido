package main.java.vendas.online.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.rpires.vendas.online.domain.Cliente;

@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String>{

    Optional<Produto> findByCpf(Long serial);
}
