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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contrasenya == null) ? 0 : contrasenya.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (contrasenya == null) {
			if (other.contrasenya != null)
				return false;
		} else if (!contrasenya.equals(other.contrasenya))
			return false;
		return true;
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
