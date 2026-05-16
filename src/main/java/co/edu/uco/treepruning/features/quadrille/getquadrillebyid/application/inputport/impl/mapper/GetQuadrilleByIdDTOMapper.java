package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.dto.GetQuadrilleByIdDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.domain.GetQuadrilleByIdDomain;

@Mapper(componentModel = "spring")
public interface GetQuadrilleByIdDTOMapper {
    GetQuadrilleByIdDTO toDTO(GetQuadrilleByIdDomain domain);
}
