package bts.sio.azurimmo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import bts.sio.azurimmo.model.Intervention;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
	
    List<Intervention> findByEtat(String etat);
    List<Intervention> findByAppartement_Id(Long appartementId);
    List<Intervention> findByDateAfter(LocalDate date);
    List<Intervention> findByCoutGreaterThan(Double cout);
}
