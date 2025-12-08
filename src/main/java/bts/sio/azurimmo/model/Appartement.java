package bts.sio.azurimmo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="appartement")
public class Appartement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="surface")
	private Double  surface;
	
	@Column(name="nbpieces")
	private Integer nbpieces;
	
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "batiment_id")
	private Batiment batiment;

}
