package br.com.zupacademy.carla.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carla.casadocodigo.modelo.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{

	Pais findByNome(String nome);

}
