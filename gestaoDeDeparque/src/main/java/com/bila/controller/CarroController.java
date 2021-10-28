package com.bila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bila.model.Carro;
import com.bila.service.CarroNotFoundException;
import com.bila.service.CarroService;

@Controller
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService service;
	@GetMapping ("/list")
	public String showCarro(Model model) {
		List<Carro> carrosList=service.listAll();
		model.addAttribute("listcarro",carrosList);
		return  "listCarros";
	}
	

	
	@GetMapping ("/new")
	public String showNewForm(Model model,RedirectAttributes ra) {
		model.addAttribute("carro", new Carro());
		model.addAttribute("pageTitle"," Add New Car");
		
		return "carro";
	}
	
	@PostMapping("/save")
	public String  save(Carro carro,RedirectAttributes ra) {
		service.save(carro);
		ra.addFlashAttribute("msg","Carro Salvo com sucesso");
		return "redirect:list";
	}
	
	
	@GetMapping("/edit{id}")
	public String showEditForm(@PathVariable("id") int id,Model model,RedirectAttributes ra) throws CarroNotFoundException {
		Carro carro=service.get(id);
		model.addAttribute("carro",carro);
		model.addAttribute("pageTitle","Edit carro");
		ra.addFlashAttribute("msg", "Carro Actualizado com exito");
	
		return "carro";
	}
	
	@GetMapping("/delete{id}")
	public String  deleteCarro(@PathVariable("id") int id,RedirectAttributes ra) {
		service.delete(id);
		ra.addFlashAttribute("msg","Carro Eliminado com exito");
		return "redirect:list";
	}
	
	@GetMapping ("/cliente")
	public String showCliente(Model model) {
		model.addAttribute("carro", new Carro());
		
		return "cliente";
	}
	
}
