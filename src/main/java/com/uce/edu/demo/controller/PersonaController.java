package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.modelo.Persona;
import com.uce.edu.demo.service.IPersonaService;


@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/buscar") //"..." no se recomienda poner
	public String buscarTodos(Model modelo){//Model Pasa datos a la lista
		List<Persona> lista = this.personaService.buscarTodos();
		modelo.addAttribute("personas",lista);
		
		return "vistaListaPersonas";
		
	}
	
	@GetMapping("/buscarUno/{idPersona}")// {idPersona} será una variable
	public String buscarPersona(@PathVariable("idPersona") Integer id, Model modelo) { //se mapea el parametro a la etiketa 
		System.out.println("El Id: "+ id);
		Persona per = this.personaService.buscarPorId(id);
		modelo.addAttribute("persona", per);
		return "vistaListaPersonas";
	}
	
	@PutMapping("/actualizar")
	public String actualizarPersona (@PathVariable("idPersona") Integer id, Persona persona) {
		persona.setId(id);
		this.personaService.actualizar(persona);
		return "redirect:/personas/buscar";
	}
	@DeleteMapping ("/borrar{idPersona}")
	public String borrarPersona(@PathVariable ("idPersona") Integer id) {
		this.personaService.eliminar(id);
		return "redirect:/personas/buscar";
	}
	
	@PostMapping("/insertar")
	public String insertarPersona(Persona persona) {
		this.personaService.insertar(persona);
		return "redirect:/personas/buscar";
	}
	
	//MEtodos de redireccinamientos a paginas
	@GetMapping("/nuevaPersona")
	public String paginaNuevaPersona(Persona persona) {
		return "vistaNuevaPersona";
	}
	
	

}
