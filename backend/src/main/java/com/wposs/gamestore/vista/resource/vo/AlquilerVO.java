/**
 * 
 */
package com.wposs.gamestore.vista.resource.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @author Daniel
 *
 */

public class AlquilerVO {

	private Integer idAlq;
	
	@NotNull
	private Integer idCliente;
	
	@NotNull
	private Integer idJuego;
	
	private Date fechaAlquiler;
	private Date fechaVencimientoAlq;
	private Date fechaEntregaAlq;
	public Integer getIdAlq() {
		return idAlq;
	}
	public void setIdAlq(Integer idAlq) {
		this.idAlq = idAlq;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdJuego() {
		return idJuego;
	}
	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}
	public Date getFechaVencimientoAlq() {
		return fechaVencimientoAlq;
	}
	public void setFechaVencimientoAlq(Date fechaVencimientoAlq) {
		this.fechaVencimientoAlq = fechaVencimientoAlq;
	}
	public Date getFechaEntregaAlq() {
		return fechaEntregaAlq;
	}
	public void setFechaEntregaAlq(Date fechaEntregaAlq) {
		this.fechaEntregaAlq = fechaEntregaAlq;
	}
	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

}
