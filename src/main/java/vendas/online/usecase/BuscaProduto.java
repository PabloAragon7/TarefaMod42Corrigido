package main.java.vendas.online.usecase;

import java.util.Optional;

import main.java.vendas.online.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rpires.vendas.online.domain.Produto;
import br.com.rpires.vendas.online.exception.EntityNotFoundException;
import br.com.rpires.vendas.online.repository.IProdutoRepository;


@Service
public class BuscaProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public BuscaProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> buscar(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto buscarPorId(String id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Produto.class, "id", id));
    }

    public Boolean isCadastrado(String id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? true : false;
    }

    public Produto buscarPorCodigo(Long codigo) {
        return produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", String.valueOf(codigo)));
    }


}