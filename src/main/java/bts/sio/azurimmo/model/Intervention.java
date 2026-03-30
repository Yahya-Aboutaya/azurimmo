package bts.sio.azurimmo.model;

import java.sql.Date;
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
@Table(name="intervention")
public class Intervention {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="date")
    private LocalDate date;
	
	@Column(name="sujet")
    private String sujet;
	
	@Column(name="cout")
    private Double cout;
	
	@Column(name="etat")
    private String etat;
    
    @ManyToOne
    @JoinColumn(name = "appartement_id")
    private Appartement appartement;


}
