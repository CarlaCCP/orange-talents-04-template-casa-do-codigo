package br.com.zupacademy.carla.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carla.casadocodigo.modelo.novoLivro;

public interface novoLivroRepository extends JpaRepository<novoLivro, Long> {

	//novoLivro findByCategoria_Nome(String nome);
	Optional<novoLivro> findById(Long id);

	Optional<novoLivro> findByTitulo(String titulo);

	Optional<novoLivro> findByIsbn(String isbn);
}
