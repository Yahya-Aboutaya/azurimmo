package bts.sio.azurimmo.model.mapper;

import org.springframework.beans.BeanUtils;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.model.dto.ContratDTO;

public class ContratMapper {
	public static ContratDTO toDTO(Contrat entity) {
        ContratDTO dto = new ContratDTO();
        BeanUtils.copyProperties(entity, dto);
        
        if (entity.getAppartement() != null) {
            dto.setAppartementId(entity.getAppartement().getId());
        }
        
        return dto;
    }
	
	public static Contrat toEntity(ContratDTO dto) {
        Contrat entity = new Contrat();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
}