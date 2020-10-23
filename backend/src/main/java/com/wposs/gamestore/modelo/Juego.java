/**
 * 
 */
package com.wposs.gamestore.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Daniel
 *
 */

@Entity
@Table(name="juego")
public class Juego {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idJue;

	private String nombreJue;
	private String directorJue;
	private String protagonistaJue;
	private String productorJue;
	private String marcaJue;
	private String precioJue;
	

	@OneToMany(mappedBy = "juego")
	private Set<Alquiler> alquilados;

	@ManyToOne
	@JoinColumn(name="idTec")
	private Tecnologia tecnologia;

	public Integer getIdJue() {
		return idJue;
	}

	public void setIdJue(Integer idJue) {
		this.idJue = idJue;
	}

	public String getNombreJue() {
		return nombreJue;
	}

	public void setNombreJue(String nombreJue) {
		this.nombreJue = nombreJue;
	}

	public String getDirectorJue() {
		return directorJue;
	}

	public void setDirectorJue(String directorJue) {
		this.directorJue = directorJue;
	}

	public String getProtagonistaJue() {
		return protagonistaJue;
	}

	public void setProtagonistaJue(String protagonistaJue) {
		this.protagonistaJue = protagonistaJue;
	}

	public String getProductorJue() {
		return productorJue;
	}

	public void setProductorJue(String productorJue) {
		this.productorJue = productorJue;
	}

	public String getMarcaJue() {
		return marcaJue;
	}

	public void setMarcaJue(String marcaJue) {
		this.marcaJue = marcaJue;
	}

	public String getPrecioJue() {
		return precioJue;
	}

	public void setPrecioJue(String precioJue) {
		this.precioJue = precioJue;
	}
/*
	public Set<Alquiler> getAlquilados() {
		return alquilados;
	}

	public void setAlquilados(Set<Alquiler> alquilados) {
		this.alquilados = alquilados;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
*/
}
