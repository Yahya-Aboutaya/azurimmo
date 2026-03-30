package bts.sio.azurimmo.repository;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bts.sio.azurimmo.model.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
   
    List<Paiement> findByContrat_Id(Long contratId);
    List<Paiement> findByDate(LocalDate date);
}