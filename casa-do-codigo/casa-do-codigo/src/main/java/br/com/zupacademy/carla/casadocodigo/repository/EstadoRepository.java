package br.com.zupacademy.carla.casadocodigo.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carla.casadocodigo.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Estado findByPais_Nome(@NotNull String nome);

}
