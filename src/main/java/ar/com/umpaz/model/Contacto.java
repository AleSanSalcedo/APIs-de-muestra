package ar.com.umpaz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

import lombok.Data;


@Data
@Entity
@Table(name="CONTACTOS")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long contactoId;
	@Column(name="TELEFONO")
	public String telefono;
	@OneToOne
	@JoinColumn(name="id")
	public Cliente cliente;
	
	@OneToMany(mappedBy = "contacto", fetch = FetchType.LAZY)
	public List<Factura> facturas;
	
	
}
