package com.raulzito.algamoneyapi.repository;

import com.raulzito.algamoneyapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
