package main.java.vendas.online.resources;

import javax.validation.Valid;

import main.java.vendas.online.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpires.vendas.online.domain.Produto;
import br.com.rpires.vendas.online.usecase.BuscaProduto;
import br.com.rpires.vendas.online.usecase.CadastroProduto;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    private BuscaProduto buscaProduto;
    private CadastroProduto cadastroProduto;

    @Autowired
    public ProdutoResource(BuscaProduto buscaProduto,
                           CadastroProduto cadastroProduto) {
        this.buscaProduto = buscaProduto;
        this.cadastroProduto = cadastroProduto;
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {
        return ResponseEntity.ok(buscaProduto.buscar(pageable));
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um produto pelo código")
    public ResponseEntity<Produto> buscarPorCódigo(@PathVariable(value = "código", required = true) String id) {
        return ResponseEntity.ok(buscaProduto.buscarPorCódigo(codigo));
    }

    @GetMapping(value = "isCadastrado/{id}")
    public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "código", required = true) String id) {
        return ResponseEntity.ok(buscaProduto.isCadastrado(id));
    }

    @PostMapping
    public ResponseEntity<Produto> cadastar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
    }

    @GetMapping(value = "/serial/{serial}")
    @Operation(summary = "Busca um produto pelo serial")
    public ResponseEntity<Produto> buscarPorSerial(@PathVariable(value = "cpf", required = true) Long cpf) {
        return ResponseEntity.ok(buscaProduto.buscarPorSerial(serial));
    }

    @PutMapping
    @Operation(summary = "Atualiza um produto")
    public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.atualizar(produto));
    }

    @DeleteMapping(value = "/{código}")
    @Operation(summary = "Remove um produto pelo seu código")
    public ResponseEntity<String> remover(@PathVariable(value = "código") String id) {
        cadastroProduto.remover(id);
        return ResponseEntity.ok("Removido com sucesso");
    }

}

