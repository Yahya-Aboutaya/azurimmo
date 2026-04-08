package bts.sio.azurimmo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
// import jakarta.persistence.ManyToMany; // Décommente si tu utilises la liste en bas
import lombok.Data;
// import java.util.List;

@Data
@Entity
@Table(name="associe")
public class Associe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Toujours un 'L' majuscule pour l'ID !

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="tel")
    private String tel;

    @Column(name="mail")
    private String mail;

    @ManyToMany(mappedBy = "associes")
    private List<Batiment> batiments;
}