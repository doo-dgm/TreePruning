package co.edu.uco.treepruning.features.pruning.gettree.application.usecase.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.uco.treepruning.features.pruning
        .gettree.application.usecase.GetTreeUseCase;
import co.edu.uco.treepruning.features.pruning
        .gettree.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.pruning.gettree.application.usecase.impl.mapper.GetTreeDomainMapper;
import co.edu.uco.treepruning.infrastructure.persistence
        .repository.TreeRepository;

@Service
public class GetTreeUseCaseImpl implements GetTreeUseCase {

    private final TreeRepository treeRepository;
    private final GetTreeDomainMapper mapper;

    public GetTreeUseCaseImpl(TreeRepository treeRepository,
            GetTreeDomainMapper mapper) {
        this.treeRepository = treeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetTreeDomain> execute(Void data) {
        return treeRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}