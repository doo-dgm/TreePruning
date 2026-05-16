package co.edu.uco.treepruning.features.pruning.getquadrille.application.inputport.impl.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.pruning.getquadrille.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.domain.GetQuadrilleDomain;

@Mapper(componentModel = "spring")
public interface GetQuadrilleDTOMapper {
	
    GetQuadrilleDTO toDTO(GetQuadrilleDomain domain);
    
    List<GetQuadrilleDTO> toDTOList(List<GetQuadrilleDomain> domains);
}
