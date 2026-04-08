package bts.sio.azurimmo.model.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;
@Data
public class ContratDTO {
	private Integer numeroBail;
	private Date dateDebut;
	private Date dateFin;
	private Double loyersanscharge;
	private Double montantcharge;
	private Long appartementId;
	private List<Long> locataireIds;
}
