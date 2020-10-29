/**
 * 
 */
package com.wposs.gamestore.vista.resource.vo;

import java.util.Date;

/**
 * @author Daniel
 *
 */

public class AlquilerVO {

	private Integer idAlq;
	
	private Date fechaAlq = new Date();
	private Date fechaVencimientoAlq;
	private Date fechaEntregaAlq;

	public Integer getIdAlq() {
		return idAlq;
	}

	public void setIdAlq(Integer idAlq) {
		this.idAlq = idAlq;
	}

	public Date getFechaAlq() {
		return fechaAlq;
	}

	public void setFechaAlq(Date fechaAlq) {
		this.fechaAlq = fechaAlq;
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
}
