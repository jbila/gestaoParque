package com.bila.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bila.model.Cliente;
import com.bila.repository.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public  List<Cliente> listAll(){
		return  (List<Cliente>) repo.findAll();
		
	}

	public void save(Cliente Cliente) {
		repo.save(Cliente);
		
	}
	public Cliente get (int id) throws ClienteNotFoundException {
		
		Optional<Cliente>  result =repo.findById(id);
		if(result.isPresent()) 
			return result.get();
		
		throw new ClienteNotFoundException("Could not find and Cliente by id"+id);
		
	}

	public void  delete(Integer id) {
		repo.deleteById(id);
		
	}
	 

}
