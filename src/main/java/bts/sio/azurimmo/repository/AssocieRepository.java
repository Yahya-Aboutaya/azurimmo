package bts.sio.azurimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bts.sio.azurimmo.model.Associe;

@Repository
public interface AssocieRepository extends JpaRepository<Associe, Long> {
	List<Associe> findByNom(String nom);
	Associe findByMail(String mail);
	Associe findByTel(String tel);
	List<Associe> findByBatiments_Id(Long batimentId);
	
}
