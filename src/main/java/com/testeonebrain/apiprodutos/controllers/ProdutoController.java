package com.testeonebrain.apiprodutos.controllers;

import com.testeonebrain.apiprodutos.dtos.ProdutoDTO;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import com.testeonebrain.apiprodutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "x", maxAge = 3600)
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> saveProduct(@RequestBody ProdutoDTO productDto) {
        productDto = produtoService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoModel>> findAll(@PageableDefault(page =0, size =10, sort = "produtoId", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll(pageable));
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "produtoId")Long produtoId){
        Optional<ProdutoModel> produtoModel = produtoService.findById(produtoId);
        if (!produtoModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        } if (!produtoModel.get().isAtivo()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("product is not active");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(produtoModel.get());
        }
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoDTO> updatProduct(@PathVariable(value = "produtoId")Long productId, @RequestBody ProdutoDTO productDto) {
            productDto = produtoService.update(productId, productDto);
            return ResponseEntity.ok().body(productDto);
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "produtoId")Long productId){
        Optional<ProdutoModel> produtoModel = produtoService.findById(productId);
        if (!produtoModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        } else {
            produtoService.delete(produtoModel.get());
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted succes");
        }
    }

    @GetMapping("/marcas/{marca}")
    public ResponseEntity<Page<ProdutoModel>> getProdutoByMarca(@PathVariable(value = "marca")String marca, @PageableDefault(page =0, size =10, sort = "marca", direction = Sort.Direction.ASC)Pageable pageable){
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.findByMarca(marca, pageable));
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<Page<ProdutoModel>> getProdutoByCategoria(@PathVariable(value = "categoriaId")Long categoriaId, @PageableDefault(page =0, size =10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.findByCategoria(categoriaId, pageable));
    }

    @PutMapping("/{produtoId}/desativar")
    public ResponseEntity<Object> desativarProduct(@PathVariable(value = "produtoId")Long productId, ProdutoDTO productDto) {
        productDto = produtoService.inativarProduto(productId, productDto);
        return ResponseEntity.ok().body("Produto desativado com Sucesso");
    }

    @PutMapping("/{produtoId}/ativar")
    public ResponseEntity<Object> ativarProduct(@PathVariable(value = "produtoId")Long productId, ProdutoDTO productDto) {
        productDto = produtoService.ativarProduto(productId, productDto);
        return ResponseEntity.ok().body("Produto ativado com Sucesso");
    }
}
