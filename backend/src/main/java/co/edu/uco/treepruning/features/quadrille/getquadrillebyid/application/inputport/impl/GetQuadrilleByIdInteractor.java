package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.GetQuadrilleByIdInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.dto.GetQuadrilleByIdDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.impl.mapper.GetQuadrilleByIdDTOMapper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.GetQuadrilleByIdUseCase;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.impl.mapper.GetQuadrilleByIdDomainMapper;

@Service
public class GetQuadrilleByIdInteractor implements GetQuadrilleByIdInputPort {

    private final GetQuadrilleByIdUseCase useCase;
    private final GetQuadrilleByIdDomainMapper domainMapper;
    private final GetQuadrilleByIdDTOMapper dtoMapper;

    public GetQuadrilleByIdInteractor(GetQuadrilleByIdUseCase useCase,
            GetQuadrilleByIdDomainMapper domainMapper,
            GetQuadrilleByIdDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.domainMapper = domainMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public GetQuadrilleByIdDTO execute(UUID id) {
        return dtoMapper.toDTO(domainMapper.toDomain(useCase.execute(id)));
    }
}
