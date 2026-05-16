package co.edu.uco.treepruning.features.pruning.gettype.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.gettype.application.inputport.GetTypeInputPort;
import co.edu.uco.treepruning.features.pruning.gettype.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.pruning.gettype.application.inputport.impl.mapper.GetTypeDTOMapper;
import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.GetTypeUseCase;

@Service
public class GetTypeInteractor implements GetTypeInputPort {

    private final GetTypeUseCase useCase;
    private final GetTypeDTOMapper mapper;

    public GetTypeInteractor(GetTypeUseCase useCase,
            GetTypeDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public List<GetTypeDTO> execute(Void data) {
        return useCase.execute(null)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
