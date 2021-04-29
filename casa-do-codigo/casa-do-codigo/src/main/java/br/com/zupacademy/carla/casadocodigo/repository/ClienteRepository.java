package br.com.zupacademy.carla.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.carla.casadocodigo.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
