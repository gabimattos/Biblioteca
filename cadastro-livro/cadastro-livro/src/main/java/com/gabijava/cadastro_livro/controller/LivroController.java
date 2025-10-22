package com.gabijava.cadastro_livro.controller;

import com.gabijava.cadastro_livro.business.LivroService;
import com.gabijava.cadastro_livro.infrastructure.entity.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Void> salvarLivro(@RequestBody Livro livro) {
        livroService.salvarLivro(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Livro> buscarLivroPorId(@RequestParam Integer id){
        Livro livroEncontrado = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok(livroEncontrado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarLivroPorId(@RequestParam Integer id){
        livroService.deletarLivroPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarLivroPorId(@RequestParam Integer id, @RequestBody Livro livro){
        livroService.atualizarLivroPorId(id, livro);
        return ResponseEntity.ok().build();
    }
}
