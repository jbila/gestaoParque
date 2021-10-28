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

import com.bila.model.Cliente;
import com.bila.service.ClienteNotFoundException;
import com.bila.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	@GetMapping ("")
	public String showcliente(Model model) {
		List<Cliente> listCliente=service.listAll();
		model.addAttribute("listCliente",listCliente);
		return  "Cliente";
	}
	

	
	@GetMapping ("/new")
	public String showNewForm(Model model,RedirectAttributes ra) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("pageTitle"," Add New cliente");
		
		return "cliente-form";
	}
	
	@PostMapping("/save")
	public String  save(Cliente cliente,RedirectAttributes ra) {
		service.save(cliente);
		ra.addFlashAttribute("msg","The cliente has been saved successfully");
		return "redirect:/Cliente";
	}
	
	
	@GetMapping("/edit{id}")
	public String showEditForm(@PathVariable("id") int id,Model model,RedirectAttributes ra) throws ClienteNotFoundException {
		Cliente cliente=service.get(id);
		model.addAttribute("cliente",cliente);
		model.addAttribute("pageTitle","Edit cliente");
		ra.addFlashAttribute("msg", "The cliente has been updated successfully");
	
		return "cliente-form";
	}
	
	@GetMapping("/delete{id}")
	public String  deletecliente(@PathVariable("id") int id,RedirectAttributes ra) {
		service.delete(id);
		ra.addFlashAttribute("msg","The cliente has been deleted successfully");
		return "redirect:/Cliente";
	}
	
}
