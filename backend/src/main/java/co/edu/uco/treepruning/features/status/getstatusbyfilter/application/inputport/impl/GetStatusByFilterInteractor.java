package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.GetStatusByFilterInputPort;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusFilterDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.impl.mapper.GetStatusDTOMapper;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.GetStatusByFilterUseCase;

@Service
public class GetStatusByFilterInteractor implements GetStatusByFilterInputPort {

    private final GetStatusByFilterUseCase useCase;
    private final GetStatusDTOMapper dtoMapper;

    public GetStatusByFilterInteractor(GetStatusByFilterUseCase useCase,
            GetStatusDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetStatusDTO> execute(GetStatusFilterDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
