package co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.impl.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.domain.GetStatusDomain;

@Mapper(componentModel = "spring")
public interface GetStatusDTOMapper {
    GetStatusDTO toDTO(GetStatusDomain domain);
    
    List<GetStatusDTO> toDTOList(List<GetStatusDomain> domains);
}
