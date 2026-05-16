package co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.GetStatusByIdInputPort;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.dto.GetStatusByIdDTO;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.inputport.impl.mapper.GetStatusByIdDTOMapper;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.usecase.GetStatusByIdUseCase;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.usecase.impl.mapper.GetStatusByIdDomainMapper;

@Service
public class GetStatusByIdInteractor implements GetStatusByIdInputPort {

    private final GetStatusByIdUseCase useCase;
    private final GetStatusByIdDomainMapper domainMapper;
    private final GetStatusByIdDTOMapper dtoMapper;

    public GetStatusByIdInteractor(GetStatusByIdUseCase useCase,
            GetStatusByIdDomainMapper domainMapper,
            GetStatusByIdDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.domainMapper = domainMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public GetStatusByIdDTO execute(UUID id) {
        return dtoMapper.toDTO(domainMapper.toDomain(useCase.execute(id)));
    }
}
