package co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.GetTreeByIdInputPort;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.dto.GetTreeByIdDTO;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.impl.mapper.GetTreeByIdDTOMapper;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.usecase.GetTreeByIdUseCase;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.usecase.impl.mapper.GetTreeByIdDomainMapper;

@Service
public class GetTreeByIdInteractor implements GetTreeByIdInputPort {

    private final GetTreeByIdUseCase useCase;
    private final GetTreeByIdDomainMapper domainMapper;
    private final GetTreeByIdDTOMapper dtoMapper;

    public GetTreeByIdInteractor(GetTreeByIdUseCase useCase,
            GetTreeByIdDomainMapper domainMapper,
            GetTreeByIdDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.domainMapper = domainMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public GetTreeByIdDTO execute(UUID id) {
        return dtoMapper.toDTO(domainMapper.toDomain(useCase.execute(id)));
    }
}
