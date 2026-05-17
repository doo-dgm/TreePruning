package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;

@Mapper(componentModel = "spring")
public interface GetTreeDTOMapper {
    GetTreeDTO toDTO(GetTreeDomain domain);
}
