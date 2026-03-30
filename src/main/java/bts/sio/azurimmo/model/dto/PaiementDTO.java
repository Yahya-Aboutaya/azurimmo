package bts.sio.azurimmo.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PaiementDTO {
    
    private Long id;
    private Double montant;
    private LocalDate date;
    
    private Long contratId; 
}