package ar.com.umpaz.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="CLIENTES")
public class Cliente {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name="NOMBRE")
	public String nombre;
	@Column(name="APELLIDO")
	public String apellido;
	@Column(name="DNI")
	public String dni;
	
	@OneToOne(mappedBy = "cliente" ,cascade = CascadeType.ALL)
	public Contacto contacto;
}
