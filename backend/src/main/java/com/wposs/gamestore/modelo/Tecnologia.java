/**
 * 
 */
package com.wposs.gamestore.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Daniel
 *
 */

@Entity
@Table(name="tecnologia")
public class Tecnologia {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTec;

	private String nombreTec;

	@OneToMany(mappedBy = "tecnologia")
	private Set<Alquiler> tecnologias;

	public Integer getIdTec() {
		return idTec;
	}

	public void setIdTec(Integer idTec) {
		this.idTec = idTec;
	}

	public String getNombreTec() {
		return nombreTec;
	}

	public void setNombreTec(String nombreTec) {
		this.nombreTec = nombreTec;
	}

	public Set<Alquiler> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(Set<Alquiler> tecnologias) {
		this.tecnologias = tecnologias;
	}
}
