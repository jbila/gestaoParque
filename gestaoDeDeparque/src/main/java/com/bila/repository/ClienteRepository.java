package com.bila.repository;

import org.springframework.data.repository.CrudRepository;

import com.bila.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
