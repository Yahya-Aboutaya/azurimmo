package bts.sio.azurimmo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "batiment")
public class Batiment {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name="adresse")
	 private String adresse;

	 @Column(name="ville")
	 private String ville;
	 
	 @OneToMany(mappedBy = "batiment")
	 private List<Appartement> appartements;
	 
	 @ManyToMany
		@JoinTable(
			name = "batiment_associe",
			joinColumns = @JoinColumn(name = "batiment_id"),
			inverseJoinColumns = @JoinColumn(name = "associe_id")
		)
		private List<Associe> associes;
}