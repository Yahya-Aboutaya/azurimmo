package bts.sio.azurimmo.model;

import java.sql.Date;

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
@Table(name="contrat")
public class Contrat {
	@ManyToOne 
	@JoinColumn(name = "appartement_id") 
	private Appartement appartement;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="numeroBail")
	private Integer numeroBail;
	
	@Column(name="dateDebut")
	private Date dateDebut;
	
	@Column(name="dateFin")
	private Date dateFin;
	
	@Column(name="loyersanscharge")
	private Double loyersanscharge;
	
	
	@Column(name="montantcharge")
	private Double montantcharge;


	public static void setContrat(Object contrat) {
		
	}

	
}
