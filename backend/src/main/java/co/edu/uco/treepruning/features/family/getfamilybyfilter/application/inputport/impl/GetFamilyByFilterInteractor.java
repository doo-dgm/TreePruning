package co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.GetFamilyByFilterInputPort;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.impl.mapper.GetFamilyDTOMapper;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.usecase.GetFamilyByFilterUseCase;

@Service
public class GetFamilyByFilterInteractor implements GetFamilyByFilterInputPort {

    private final GetFamilyByFilterUseCase useCase;
    private final GetFamilyDTOMapper dtoMapper;

    public GetFamilyByFilterInteractor(GetFamilyByFilterUseCase useCase,
            GetFamilyDTOMapper dtoMapper) {
        this.useCase = useCase;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<GetFamilyDTO> execute(GetFamilyDTO filter) {
        return useCase.execute(filter)
                .stream()
                .map(dtoMapper::toDTO)
                .toList();
    }
}
