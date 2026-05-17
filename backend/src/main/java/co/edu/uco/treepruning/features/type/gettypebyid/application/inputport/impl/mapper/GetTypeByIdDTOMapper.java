package co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.dto.GetTypeByIdDTO;
import co.edu.uco.treepruning.features.type.gettypebyid.application.usecase.domain.GetTypeByIdDomain;

@Mapper(componentModel = "spring")
public interface GetTypeByIdDTOMapper {
    GetTypeByIdDTO toDTO(GetTypeByIdDomain domain);
}
