package co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.GetTreeByFilterInputPort;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.impl.mapper.GetTreeDTOMapper;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.GetTreeByFilterUseCase;

@Service
public class GetTreeByFilterInteractor implements GetTreeByFilterInputPort {

    private final GetTreeByFilterUseCase useCase;
    private final GetTreeDTOMapper dtoMapper;

    public GetTreeByFilterInteractor(GetTreeByFilterUseCase useCase,
            GetTreeDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetTreeDTO> execute(GetTreeDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
