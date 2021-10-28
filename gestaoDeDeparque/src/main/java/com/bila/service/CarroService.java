package com.bila.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bila.model.Carro;
import com.bila.repository.CarroRepository;


@Service
public class CarroService {
	@Autowired
	private CarroRepository repo;
	
	public  List<Carro> listAll(){
		return  (List<Carro>) repo.findAll();
		
	}

	public void save(Carro carro) {
		repo.save(carro);
		
	}
	public Carro get (int id) throws CarroNotFoundException {
		
		Optional<Carro>  result =repo.findById(id);
		if(result.isPresent()) 
			return result.get();
		
		throw new CarroNotFoundException("Could not find and user by id"+id);
		
	}

	public void  delete(Integer id) {
		repo.deleteById(id);
		
	}
	 

}
