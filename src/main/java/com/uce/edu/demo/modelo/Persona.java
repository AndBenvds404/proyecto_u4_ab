package com.uce.edu.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "persona") // nombre de la tabla de la base de datos
//Forma actual
@NamedQuery(name = "Persona.buscarPorCedula", query = "SELECT p FROM Persona p WHERE p.cedula= :datocedula")
@NamedQuery(name = "Persona.buscarPorNombreApellido", query = "SELECT p FROM Persona p WHERE p.nombre= :datoNombre AND p.apellido = :datoApellido")


/* Forma antigua
@NamedQueries({
	@NamedQuery(name = "Persona.buscarPorCedula", query = "SELECT p FROM Persona p WHERE p.cedula= :datocedula"),
	@NamedQuery(name = "Persona.buscarPorNombreApellido", query = "SELECT p FROM Persona p WHERE p.nombre= :datoNombre AND p.apellido = :datoApellido")})
*/

@NamedNativeQuery(name = "Persona.buscarPorCedulaNative", query = "SELECT * FROM Persona  WHERE pers_cedula = :datoCedula")

@NamedNativeQueries({
	@NamedNativeQuery(name = "Persona.buscarPorCedulaNamedNative", query = "SELECT * FROM Persona  WHERE pers_cedula = :datoCedula", resultClass = Persona.class),
	@NamedNativeQuery(name = "Persona.buscarPorCedulaNativeApellido", query = "SELECT * FROM Persona  WHERE pers_apellido = :datoApelldio", resultClass = Persona.class)


})

public class Persona {

	@Id
	@Column(name = "pers_id") // nombre de la columna en la tabla DB
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_id_seq") // nombre (original/referencia) del																				// secuencia de la db
	@SequenceGenerator(name = "pers_id_seq", sequenceName = "pers_id_seq", allocationSize = 1) // nombre dela secuecia																				// incremento
	private Integer id;
	
	@Column(name = "pers_nombre")
	private String nombre;

	@Column(name = "pers_apellido")
	private String apellido;

	@Column(name = "pers_cedula")
	private String cedula;

	@Column(name = "pers_genero")
	private String genero;

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", genero=" + genero + "]";
	}

	// set and get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

}
