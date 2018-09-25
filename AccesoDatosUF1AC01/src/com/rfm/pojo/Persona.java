package com.rfm.pojo;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String idioma;
	private String usuario;
	private String contrasenya;
	
	public Persona() {
		
	}

	public Persona(String nombre, String apellido, String idioma, String usuario, String contrasenya) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.idioma = idioma;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", idioma=" + idioma + ", usuario=" + usuario
				+ ", contrasenya=" + contrasenya + "]";
	}
	
}
