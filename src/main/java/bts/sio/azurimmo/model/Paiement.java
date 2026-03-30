package bts.sio.azurimmo.model;

import java.time.LocalDate;

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
@Table(name="paiement")
public class Paiement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="montant")
	private Double montant;
	
	@Column(name="date")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "contrat_id")
	private Contrat contrat;
}
