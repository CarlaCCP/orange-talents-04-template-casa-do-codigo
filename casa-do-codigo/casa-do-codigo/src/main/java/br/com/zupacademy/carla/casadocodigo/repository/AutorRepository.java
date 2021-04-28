package br.com.zupacademy.carla.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carla.casadocodigo.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional <Autor> findByEmail(String email);

	Autor findByNome(String nome);


	 
}
