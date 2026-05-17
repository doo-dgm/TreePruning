package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;

@Mapper(componentModel = "spring")
public interface GetStatusDTOMapper {
    GetStatusDTO toDTO(GetStatusDomain domain);
}
