package com.gabijava.cadastro_livro.business;

import com.gabijava.cadastro_livro.infrastructure.entity.Livro;
import com.gabijava.cadastro_livro.infrastructure.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public void salvarLivro(Livro livro) {
        repository.saveAndFlush(livro);
    }

    public Livro buscarLivroPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Livro não encontrado.")
        );
    }

    @Transactional
    public void deletarLivroPorId(Integer id){
        repository.deleteById(id);
    }

    public List<Livro> buscarTodosOsLivros(){
        return repository.findAll();
    }

    public void atualizarLivroPorId(Integer id, Livro livro){
        Livro livroEntity = buscarLivroPorId(id);
        Livro livroAtualizado = Livro.builder()
                .autor(livro.getAutor() != null ? livro.getAutor() : livroEntity.getAutor())
                .title(livro.getTitle() != null ? livro.getTitle(): livroEntity.getTitle())
                .published(livro.getPublished() != null ? livro.getPublished(): livroEntity.getPublished())
                .id(livroEntity.getId())
                .build();

        repository.saveAndFlush(livroAtualizado);
    }

}
