package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningFilterDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.GetPruningByFilterUseCase;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.impl.mapper.GetPruningDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;

@Service
public class GetPruningByFilterUseCaseImpl implements GetPruningByFilterUseCase {

    private final PruningRepository pruningRepository;
    private final GetPruningDomainMapper mapper;

    public GetPruningByFilterUseCaseImpl(PruningRepository pruningRepository,
            GetPruningDomainMapper mapper) {
        this.pruningRepository = pruningRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetPruningDomain> execute(GetPruningFilterDTO filter) {
        return pruningRepository.findByFilter(
                filter.getId(), filter.getStatusId(), filter.getTreeId(),
                filter.getQuadrilleId(), filter.getTypeId(), filter.getPlannedDate())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
