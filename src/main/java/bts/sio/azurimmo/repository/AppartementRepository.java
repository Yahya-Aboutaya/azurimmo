package bts.sio.azurimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import bts.sio.azurimmo.model.Appartement;


public interface AppartementRepository extends JpaRepository<Appartement, Long> {
	
	List<Appartement> findByBatiment_Ville(String ville);
	
	List<Appartement> findByBatiment_Id(long id);
	
	List<Appartement> findBySurfaceGreaterThan(double surface);
}
