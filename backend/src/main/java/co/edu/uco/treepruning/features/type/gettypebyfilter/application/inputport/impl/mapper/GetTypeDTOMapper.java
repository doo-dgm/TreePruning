package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;

@Mapper(componentModel = "spring")
public interface GetTypeDTOMapper {
    GetTypeDTO toDTO(GetTypeDomain domain);
}
