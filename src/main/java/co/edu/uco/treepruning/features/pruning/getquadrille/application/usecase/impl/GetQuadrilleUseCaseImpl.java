package co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.GetQuadrilleUseCase;
import co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.impl.mapper.GetQuadrilleDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.QuadrilleRepository;

@Service
public class GetQuadrilleUseCaseImpl implements GetQuadrilleUseCase {

    private final QuadrilleRepository quadrilleRepository;
    private final GetQuadrilleDomainMapper mapper;

    public GetQuadrilleUseCaseImpl(
            QuadrilleRepository quadrilleRepository,
            GetQuadrilleDomainMapper mapper) {
        this.quadrilleRepository = quadrilleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetQuadrilleDomain> execute(Void data) {
        return quadrilleRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
