package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.GetTypeByFilterInputPort;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeFilterDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.impl.mapper.GetTypeDTOMapper;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.GetTypeByFilterUseCase;

@Service
public class GetTypeByFilterInteractor implements GetTypeByFilterInputPort {

    private final GetTypeByFilterUseCase useCase;
    private final GetTypeDTOMapper dtoMapper;

    public GetTypeByFilterInteractor(GetTypeByFilterUseCase useCase,
            GetTypeDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetTypeDTO> execute(GetTypeFilterDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
