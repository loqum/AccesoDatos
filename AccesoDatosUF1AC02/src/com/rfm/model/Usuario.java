package com.rfm.model;

public class Usuario extends Persona {
	
	private String contrasenya;

	public Usuario() {
		
	}
	
	public Usuario(String contrasenya) {
		super();
		this.contrasenya = contrasenya;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [nombre=");
		builder.append(getNombre());
		builder.append(", contraseña=");
		builder.append(contrasenya);
		builder.append("]");
		return builder.toString();
	}
	



}
