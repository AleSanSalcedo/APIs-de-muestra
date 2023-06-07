package ar.com.umpaz.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="FACTURAS")
public class Factura {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FACTURA_ID")
	public Long facturaId;
	public Date fecha;
	
	@ManyToOne
	@JoinColumn(name="contacto_id")
	public Contacto contacto;
	
}
