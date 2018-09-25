package com.rfm.model;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String idioma;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, String apellido, String idioma) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.idioma = idioma;
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

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", idioma=" + idioma + "]";
	}

}
