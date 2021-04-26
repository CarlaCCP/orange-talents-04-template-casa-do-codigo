package br.com.zupacademy.carla.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carla.casadocodigo.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
