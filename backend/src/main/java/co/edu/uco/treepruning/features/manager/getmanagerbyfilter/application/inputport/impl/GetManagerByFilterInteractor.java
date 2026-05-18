package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.GetManagerByFilterInputPort;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.impl.mapper.GetManagerDTOMapper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.GetManagerByFilterUseCase;

@Service
public class GetManagerByFilterInteractor implements GetManagerByFilterInputPort {

    private final GetManagerByFilterUseCase useCase;
    private final GetManagerDTOMapper dtoMapper;

    public GetManagerByFilterInteractor(GetManagerByFilterUseCase useCase,
            GetManagerDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetManagerDTO> execute(GetManagerDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
