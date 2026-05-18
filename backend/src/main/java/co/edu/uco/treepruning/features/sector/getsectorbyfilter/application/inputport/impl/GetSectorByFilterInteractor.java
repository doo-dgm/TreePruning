package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.GetSectorByFilterInputPort;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.impl.mapper.GetSectorDTOMapper;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.usecase.GetSectorByFilterUseCase;

@Service
public class GetSectorByFilterInteractor implements GetSectorByFilterInputPort {

    private final GetSectorByFilterUseCase useCase;
    private final GetSectorDTOMapper dtoMapper;

    public GetSectorByFilterInteractor(GetSectorByFilterUseCase useCase,
            GetSectorDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetSectorDTO> execute(GetSectorDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
