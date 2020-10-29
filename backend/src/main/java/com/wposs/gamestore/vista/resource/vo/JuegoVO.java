/**
 * 
 */
package com.wposs.gamestore.vista.resource.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Daniel
 *
 */

public class JuegoVO {
	

	private Integer idJue;
	@NotEmpty
	private String nombreJue;
	@NotNull
	private Integer precioJue;
	private String directorJue;
	private String protagonistaJue;
	private String productorJue;
	private String marcaJue;

	@NotNull
	private Integer idTecnologia;

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

	public Integer getPrecioJue() {
		return precioJue;
	}

	public void setPrecioJue(Integer precioJue) {
		this.precioJue = precioJue;
	}

	public Integer getIdTecnologia() {
		return idTecnologia;
	}

	public void setIdTecnologia(Integer idTecnologia) {
		this.idTecnologia = idTecnologia;
	}

}
