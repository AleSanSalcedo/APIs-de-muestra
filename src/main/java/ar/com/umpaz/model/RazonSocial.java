package ar.com.umpaz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="RAZON_SOCIAL")
public class RazonSocial {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RAZON_SOCIAL_ID")
	public Long id;
	public String razonSocial;
	
	@Fetch(FetchMode.JOIN)
	@ManyToMany(mappedBy = "razones")
	public List<Usuario> usuario;
	

}
