package br.com.zupacademy.carla.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carla.casadocodigo.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

	Optional <Categoria> findByNome(String nome);
}
