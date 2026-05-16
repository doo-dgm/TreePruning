package co.edu.uco.treepruning.features.pruning.gettree.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.gettree.application.inputport.GetTreeInputPort;
import co.edu.uco.treepruning.features.pruning.gettree.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.pruning.gettree.application.usecase.GetTreeUseCase;

@Service
public class GetTreeInteractor implements GetTreeInputPort {

    private final GetTreeUseCase useCase;
    private final GetTreeDTOMapper mapper;

    public GetTreeInteractor(GetTreeUseCase useCase,
            GetTreeDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public List<GetTreeDTO> execute(Void data) {
        return useCase.execute(null)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}