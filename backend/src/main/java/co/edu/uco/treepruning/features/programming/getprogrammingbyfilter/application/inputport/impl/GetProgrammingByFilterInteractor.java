package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.GetProgrammingByFilterInputPort;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.impl.mapper.GetProgrammingDTOMapper;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.usecase.GetProgrammingByFilterUseCase;

@Service
public class GetProgrammingByFilterInteractor implements GetProgrammingByFilterInputPort {

    private final GetProgrammingByFilterUseCase useCase;
    private final GetProgrammingDTOMapper dtoMapper;

    public GetProgrammingByFilterInteractor(GetProgrammingByFilterUseCase useCase,
            GetProgrammingDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetProgrammingDTO> execute(GetProgrammingDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
