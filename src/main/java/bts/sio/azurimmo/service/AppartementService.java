package bts.sio.azurimmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.model.mapper.AppartementMapper;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.BatimentRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Service
public class AppartementService {
	
	
	
	 @Autowired
	 private AppartementRepository appartementRepository;
	 
	 @Autowired
	 private BatimentRepository batimentRepository;
	 
	// public Appartement createAppartementForBatiment(Long natimentId, Appartement nouvelAppartement) {
	//	 Batiment batimentPere = batimentRepository.findById(batimentId)
		//		 .orElseThrow(() -> new RuntimeException("Bâtiment introuvable !"));
		 
	// }

	 public Appartement saveAppartement(Appartement appartement) {
		 Appartement savedAppartement = appartementRepository.save(appartement);
	     return savedAppartement;
	 }
	 
	 public List<Appartement> findByVille(String ville) {
		 return appartementRepository.findByBatiment_Ville(ville);
	}
	 
	 public List<Appartement> getAppartementsParBatiment(long id) {
	        return appartementRepository.findByBatiment_Id(id);
	 }
	 
	 public List<Appartement> getAppartementsBySurfaceGreatherThan(double surface) {
	        return appartementRepository.findBySurfaceGreaterThan(surface);
	 }
	 
	 public AppartementDTO saveAppartementDTO(AppartementDTO dto) {
		 Appartement entity = AppartementMapper.toEntity(dto);
		 
		 if (dto.getBatimentId() != null) {
			 Batiment bat = batimentRepository.findById(dto.getBatimentId()).orElse(null);
			 entity.setBatiment(bat);
		 }
		 
		 Appartement saved = appartementRepository.save(entity);
		 return AppartementMapper.toDTO(saved);
		 
		 
	 }

}