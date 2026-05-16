package co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.dto.GetTreeByIdDTO;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.usecase.domain.GetTreeByIdDomain;

@Mapper(componentModel = "spring")
public interface GetTreeByIdDTOMapper {
    GetTreeByIdDTO toDTO(GetTreeByIdDomain domain);
}
