package co.edu.uco.treepruning.features.tree.gettree.application.inputport.impl.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.tree.gettree.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettree.application.usecase.domain.GetTreeDomain;

@Mapper(componentModel = "spring")
public interface GetTreeDTOMapper {
    GetTreeDTO toDTO(GetTreeDomain domain);
    
    List<GetTreeDTO> toDTOList(List<GetTreeDomain> domains);
}
