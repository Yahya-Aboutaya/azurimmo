package bts.sio.azurimmo.model.mapper;

import org.springframework.beans.BeanUtils;

import bts.sio.azurimmo.model.Intervention;
import bts.sio.azurimmo.model.dto.InterventionDTO;

public class InterventionMapper {

    // 1. On transforme l'Entity (Base de données) en DTO (Postman)
    public static InterventionDTO toDTO(Intervention entity) {
        InterventionDTO dto = new InterventionDTO();
        
        // BeanUtils copie les champs simples qui ont le même nom : id, date, sujet, cout, etat
        BeanUtils.copyProperties(entity, dto);
        
        // On gère la relation à la main : on extrait l'ID de l'appartement pour le mettre dans le DTO
        if (entity.getAppartement() != null) {
            dto.setAppartementId(entity.getAppartement().getId());
        }
        
        return dto;
    }

    // 2. On transforme le DTO (Postman) en Entity (Base de données)
    public static Intervention toEntity(InterventionDTO dto) {
        Intervention entity = new Intervention();
        
        // BeanUtils copie les champs simples : id, date, sujet, cout, etat
        BeanUtils.copyProperties(dto, entity);
       
        
        return entity;
    }
}