package co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.GetStatusInputPort;
import co.edu.uco.treepruning.features.pruning.getstatus.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.GetStatusUseCase;

@Service
public class GetStatusInteractor implements GetStatusInputPort {

    private final GetStatusUseCase useCase;
    private final GetStatusDTOMapper mapper;

    public GetStatusInteractor(GetStatusUseCase useCase,
            GetStatusDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public List<GetStatusDTO> execute(Void data) {
        return useCase.execute(null)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
