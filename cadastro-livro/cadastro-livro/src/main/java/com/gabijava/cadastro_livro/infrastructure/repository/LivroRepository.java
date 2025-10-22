package com.gabijava.cadastro_livro.infrastructure.repository;

import com.gabijava.cadastro_livro.infrastructure.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {


}
