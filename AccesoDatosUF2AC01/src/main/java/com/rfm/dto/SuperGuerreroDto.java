package com.rfm.dto;

public class SuperGuerreroDto extends SuperEspecieDto {

	private long idSuperGuerrero;
	private long idSuperEspecie;
	private String nombre;
	private String descripcion;
	private String tipoPoder;
	private int nivelPoder;

	public SuperGuerreroDto() {

	}

	public SuperGuerreroDto(long idSuperEspecie, String nombre, long idSuperGuerrero, String descripcion,
			String tipoPoder, int nivelPoder) {
		super(idSuperEspecie, nombre);
		this.idSuperGuerrero = idSuperGuerrero;
		this.descripcion = descripcion;
		this.tipoPoder = tipoPoder;
		this.nivelPoder = nivelPoder;
	}

	public long getIdSuperGuerrero() {
		return idSuperGuerrero;
	}

	@Override
	public long getIdSuperEspecie() {
		return idSuperEspecie;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoPoder() {
		return tipoPoder;
	}

	public void setTipoPoder(String tipoPoder) {
		this.tipoPoder = tipoPoder;
	}

	public int getNivelPoder() {
		return nivelPoder;
	}

	public void setNivelPoder(int nivelPoder) {
		this.nivelPoder = nivelPoder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (idSuperEspecie ^ (idSuperEspecie >>> 32));
		result = prime * result + (int) (idSuperGuerrero ^ (idSuperGuerrero >>> 32));
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
		SuperGuerreroDto other = (SuperGuerreroDto) obj;
		if (idSuperEspecie != other.idSuperEspecie)
			return false;
		if (idSuperGuerrero != other.idSuperGuerrero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SuperGuerrero [idSuperGuerrero=");
		builder.append(idSuperGuerrero);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripción=");
		builder.append(descripcion);
		builder.append(", tipoPoder=");
		builder.append(tipoPoder);
		builder.append(", nivelPoder=");
		builder.append(nivelPoder);
		builder.append("]");
		return builder.toString();
	}

}
