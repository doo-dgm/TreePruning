package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;

@Mapper(componentModel = "spring")
public interface GetQuadrilleDTOMapper {
    GetQuadrilleDTO toDTO(GetQuadrilleDomain domain);
}
