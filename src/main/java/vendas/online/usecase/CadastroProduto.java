package main.java.vendas.online.usecase;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rpires.vendas.online.domain.Produto;
import br.com.rpires.vendas.online.repository.IProdutoRepository;


@Service
public class CadastroProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public CadastroProduto(IPRodutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(@Valid Produto produto) {
        return this.produtoRepository.insert(produto);
    }

    public Produto atualizar(@Valid Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public void remover(String id) {
        this.produtoRepository.deleteById(id);
    }

}