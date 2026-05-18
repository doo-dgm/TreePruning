package co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.GetPersonByFilterInputPort;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.impl.mapper.GetPersonDTOMapper;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.GetPersonByFilterUseCase;

@Service
public class GetPersonByFilterInteractor implements GetPersonByFilterInputPort {

    private final GetPersonByFilterUseCase useCase;
    private final GetPersonDTOMapper dtoMapper;

    public GetPersonByFilterInteractor(GetPersonByFilterUseCase useCase,
            GetPersonDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetPersonDTO> execute(GetPersonDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
