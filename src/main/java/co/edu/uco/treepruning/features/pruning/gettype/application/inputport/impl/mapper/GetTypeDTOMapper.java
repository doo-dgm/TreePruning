package co.edu.uco.treepruning.features.pruning.gettype.application.inputport.impl.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.pruning.gettype.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.domain.GetTypeDomain;

@Mapper(componentModel = "spring")
public interface GetTypeDTOMapper {
    GetTypeDTO toDTO(GetTypeDomain domain);
    
    List<GetTypeDTO> toDTOList(List<GetTypeDomain> domains);
}