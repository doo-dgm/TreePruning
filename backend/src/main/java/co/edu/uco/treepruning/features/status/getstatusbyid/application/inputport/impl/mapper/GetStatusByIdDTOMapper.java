package co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.dto.GetStatusByIdDTO;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.usecase.domain.GetStatusByIdDomain;

@Mapper(componentModel = "spring")
public interface GetStatusByIdDTOMapper {
    GetStatusByIdDTO toDTO(GetStatusByIdDomain domain);
}
