package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.GetPruningByFilterInputPort;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.impl.mapper.GetPruningDTOMapper;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.GetPruningByFilterUseCase;

@Service
public class GetPruningByFilterInteractor implements GetPruningByFilterInputPort {

    private final GetPruningByFilterUseCase useCase;
    private final GetPruningDTOMapper dtoMapper;

    public GetPruningByFilterInteractor(GetPruningByFilterUseCase useCase,
            GetPruningDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetPruningDTO> execute(GetPruningDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
