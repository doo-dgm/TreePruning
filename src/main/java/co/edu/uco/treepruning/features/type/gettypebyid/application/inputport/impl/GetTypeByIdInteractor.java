package co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.GetTypeByIdInputPort;
import co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.dto.GetTypeByIdDTO;
import co.edu.uco.treepruning.features.type.gettypebyid.application.inputport.impl.mapper.GetTypeByIdDTOMapper;
import co.edu.uco.treepruning.features.type.gettypebyid.application.usecase.GetTypeByIdUseCase;
import co.edu.uco.treepruning.features.type.gettypebyid.application.usecase.impl.mapper.GetTypeByIdDomainMapper;

@Service
public class GetTypeByIdInteractor implements GetTypeByIdInputPort {

    private final GetTypeByIdUseCase useCase;
    private final GetTypeByIdDomainMapper domainMapper;
    private final GetTypeByIdDTOMapper dtoMapper;

    public GetTypeByIdInteractor(GetTypeByIdUseCase useCase,
            GetTypeByIdDomainMapper domainMapper,
            GetTypeByIdDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.domainMapper = domainMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public GetTypeByIdDTO execute(UUID id) {
        return dtoMapper.toDTO(domainMapper.toDomain(useCase.execute(id)));
    }
}
