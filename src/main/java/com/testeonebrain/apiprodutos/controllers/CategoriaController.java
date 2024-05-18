package com.testeonebrain.apiprodutos.controllers;

import com.testeonebrain.apiprodutos.dtos.CategoriaDTO;
import com.testeonebrain.apiprodutos.model.CategoriaModel;
import com.testeonebrain.apiprodutos.model.ProdutoModel;
import com.testeonebrain.apiprodutos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "x", maxAge = 3600)
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> saveProduct(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO = categoriaService.save(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTO);
    }

    @GetMapping
    public ResponseEntity<Page<CategoriaModel>> findAll(@PageableDefault(page =0, size =10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll(pageable));
    }

    @PutMapping("/{categoriaId}/desativar")
    public ResponseEntity<Object> desativarProduct(@PathVariable(value = "categoriaId")Long categoriaId, CategoriaDTO categoriaDTO) {
        categoriaDTO = categoriaService.inativarProduto(categoriaId, categoriaDTO);
        return ResponseEntity.ok().body("Categoria desativada com Sucesso");
    }

    @PutMapping("/{categoriaId}/ativar")
    public ResponseEntity<Object> ativarProduct(@PathVariable(value = "categoriaId")Long categoriaId, CategoriaDTO categoriaDTO) {
        categoriaDTO = categoriaService.ativarProduto(categoriaId, categoriaDTO);
        return ResponseEntity.ok().body("Categoria ativada com Sucesso");
    }
}
