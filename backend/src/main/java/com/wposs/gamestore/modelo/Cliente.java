/**
 * 
 */
package com.wposs.gamestore.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author Daniel
 *
 */
@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCli;
	
	private String nombreCli;
	private String documentoCli;
	private String telefonoCli;
	@Temporal(TemporalType.DATE)
	private Date fechaNacimientoCli;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Alquiler> alquileres;
	

	public Integer getIdCli() {
		return idCli;
	}


	public void setIdCli(Integer idCli) {
		this.idCli = idCli;
	}


	public String getNombreCli() {
		return nombreCli;
	}


	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}


	public String getDocumentoCli() {
		return documentoCli;
	}


	public void setDocumentoCli(String documentoCli) {
		this.documentoCli = documentoCli;
	}


	public String getTelefonoCli() {
		return telefonoCli;
	}


	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}


	public Date getFechaNacimientoCli() {
		return fechaNacimientoCli;
	}


	public void setFechaNacimientoCli(Date fechaNacimientoCli) {
		this.fechaNacimientoCli = fechaNacimientoCli;
	}

	public Set<Alquiler> getAlquileres() {
		return alquileres;
	}


	public void setAlquileres(Set<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}


}
