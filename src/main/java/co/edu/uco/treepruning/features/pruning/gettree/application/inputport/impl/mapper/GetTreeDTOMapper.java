package co.edu.uco.treepruning.features.pruning.gettree.application.inputport.impl.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.pruning.gettree.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.pruning.gettree.application.usecase.domain.GetTreeDomain;

@Mapper(componentModel = "spring")
public interface GetTreeDTOMapper {
    GetTreeDTO toDTO(GetTreeDomain domain);
    
    List<GetTreeDTO> toDTOList(List<GetTreeDomain> domains);
}
