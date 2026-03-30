package bts.sio.azurimmo.model.mapper;
import org.springframework.beans.BeanUtils;
import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.model.dto.PaiementDTO;

public class PaiementMapper {

    public static PaiementDTO toDTO(Paiement entity) {
        PaiementDTO dto = new PaiementDTO();
        
        
        BeanUtils.copyProperties(entity, dto);
        // Si le paiement est bien lié à un contrat en base de données...
        if (entity.getContrat() != null) {
            //alors on prend l'ID de ce contrat, et on le met dans le DTO
            dto.setContratId(entity.getContrat().getId());
        }
        
        return dto;
    }

    public static Paiement toEntity(PaiementDTO dto) {
        Paiement entity = new Paiement();
        
        // On copie (id, date, montant)
        BeanUtils.copyProperties(dto, entity);
        
        return entity;
    }
}
