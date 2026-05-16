package co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.GetStatusUseCase;
import co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.pruning.getstatus.application.usecase.impl.mapper.GetStatusDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.StatusRepository;

@Service
public class GetStatusUseCaseImpl implements GetStatusUseCase {

    private final StatusRepository statusRepository;
    private final GetStatusDomainMapper mapper;

    public GetStatusUseCaseImpl(StatusRepository statusRepository,
            GetStatusDomainMapper mapper) {
        this.statusRepository = statusRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetStatusDomain> execute(Void data) {
        return statusRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}