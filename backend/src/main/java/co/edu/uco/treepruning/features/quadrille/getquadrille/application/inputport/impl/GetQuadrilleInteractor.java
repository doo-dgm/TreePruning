package co.edu.uco.treepruning.features.quadrille.getquadrille.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.quadrille.getquadrille.application.inputport.GetQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrille.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrille.application.inputport.impl.mapper.GetQuadrilleDTOMapper;
import co.edu.uco.treepruning.features.quadrille.getquadrille.application.usecase.GetQuadrilleUseCase;

@Service
public class GetQuadrilleInteractor
        implements GetQuadrilleInputPort {

    private final GetQuadrilleUseCase useCase;
    private final GetQuadrilleDTOMapper mapper;

    public GetQuadrilleInteractor(GetQuadrilleUseCase useCase,
            GetQuadrilleDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public List<GetQuadrilleDTO> execute(Void data) {
        return useCase.execute(null)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
