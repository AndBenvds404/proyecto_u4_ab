package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.modelo.Persona;

public interface IPersonaService {
	
	public Persona buscarPorId (Integer id);
	
	public void insertar (Persona p);
	
	public void actualizar (Persona p);
	
	public void eliminar(Integer id);

	public List<Persona> buscarTodos ();
	
}
