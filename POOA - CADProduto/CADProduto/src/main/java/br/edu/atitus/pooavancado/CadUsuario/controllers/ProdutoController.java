package br.edu.atitus.pooavancado.CadUsuario.controllers;

import br.edu.atitus.pooavancado.CadUsuario.services.ProdutoService;
import br.edu.atitus.pooavancado.CadUsuario.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        super();
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Object> postProdutos(@RequestBody Produto produto){
        try {
            produtoService.save(produto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<Object> getProdutos(@PageableDefault(page = 0, size = 10, sort = "id", direction =
            Sort.Direction.ASC) Pageable paginacao,
            @RequestParam(required = false) String nome, @RequestParam(required = false) String email){
        try {
            Page<Produto> lista = produtoService.findByNome(nome, paginacao);
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProdutoById(@PathVariable long id){
        Produto produto;
        try {
            produto = this.produtoService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putProduto(@PathVariable long id, @RequestBody Produto produto){
        produto.setId(id);
        try {
            produtoService.save(produto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduto(@PathVariable long id) {
        try {
            produtoService.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
