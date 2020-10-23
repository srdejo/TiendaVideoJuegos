/**
 * 
 */
package com.wposs.gamestore.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Daniel
 *
 */

@Entity
@Table(name="alquiler")
public class Alquiler {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAlq;
	@Temporal(TemporalType.DATE)
	private Date fechaAlq;
	@Temporal(TemporalType.DATE)
	private Date fechaVencimientoAlq;
	@Temporal(TemporalType.DATE)
	private Date fechaEntregaAlq;

	@ManyToOne
	@JoinColumn(name="idCli")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idJue")
	private Juego juego;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
}
