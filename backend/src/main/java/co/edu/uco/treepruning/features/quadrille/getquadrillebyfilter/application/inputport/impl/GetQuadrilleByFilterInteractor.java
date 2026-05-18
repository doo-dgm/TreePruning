package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.GetQuadrilleByFilterInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.impl.mapper.GetQuadrilleDTOMapper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.GetQuadrilleByFilterUseCase;

@Service
public class GetQuadrilleByFilterInteractor implements GetQuadrilleByFilterInputPort {

    private final GetQuadrilleByFilterUseCase useCase;
    private final GetQuadrilleDTOMapper dtoMapper;

    public GetQuadrilleByFilterInteractor(GetQuadrilleByFilterUseCase useCase,
            GetQuadrilleDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetQuadrilleDTO> execute(GetQuadrilleDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
