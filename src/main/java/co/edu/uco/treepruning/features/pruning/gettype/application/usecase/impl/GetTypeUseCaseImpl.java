package co.edu.uco.treepruning.features.pruning.gettype.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.GetTypeUseCase;
import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.impl.mapper.GetTypeDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.TypeRepository;

@Service
public class GetTypeUseCaseImpl implements GetTypeUseCase {

    private final TypeRepository typeRepository;
    
    private final GetTypeDomainMapper mapper;

    public GetTypeUseCaseImpl(TypeRepository typeRepository,
            GetTypeDomainMapper mapper) {
        this.typeRepository = typeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetTypeDomain> execute(Void data) {
        return typeRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}