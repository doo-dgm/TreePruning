package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.GetQuadrilleByIdUseCase;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.usecase.GetStatusByIdUseCase;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.usecase.GetTreeByIdUseCase;
import co.edu.uco.treepruning.features.type.gettypebyid.application.usecase.GetTypeByIdUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.mapper.SchedulePreventivePruningDomainMapper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.TreeAlreadyScheduledForDateException;
import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;

@Service
public class SchedulePreventivePruningUseCaseImpl
        implements SchedulePreventivePruningUseCase {

    private final GetTreeByIdUseCase getTreeByIdUseCase;
    private final GetQuadrilleByIdUseCase getQuadrilleByIdUseCase;
    private final GetTypeByIdUseCase getTypeByIdUseCase;
    private final GetStatusByIdUseCase getStatusByIdUseCase;
    private final PruningRepository pruningRepository;
    private final SchedulePreventivePruningDomainMapper domainMapper;

    public SchedulePreventivePruningUseCaseImpl(
            GetTreeByIdUseCase getTreeByIdUseCase,
            GetQuadrilleByIdUseCase getQuadrilleByIdUseCase,
            GetTypeByIdUseCase getTypeByIdUseCase,
            GetStatusByIdUseCase getStatusByIdUseCase,
            PruningRepository pruningRepository,
            SchedulePreventivePruningDomainMapper domainMapper) {
        this.getTreeByIdUseCase = getTreeByIdUseCase;
        this.getQuadrilleByIdUseCase = getQuadrilleByIdUseCase;
        this.getTypeByIdUseCase = getTypeByIdUseCase;
        this.getStatusByIdUseCase = getStatusByIdUseCase;
        this.pruningRepository = pruningRepository;
        this.domainMapper = domainMapper;
    }

    @Override
    public Void execute(SchedulePreventivePruningDomain data) {
        getTreeByIdUseCase.execute(data.getTree());
        getQuadrilleByIdUseCase.execute(data.getQuadrille());
        getTypeByIdUseCase.execute(data.getType());
        getStatusByIdUseCase.execute(data.getStatus());

        if (pruningRepository.existsByTreeAndPlannedDate(
                data.getTree(), data.getPlannedDate())) {
            throw TreeAlreadyScheduledForDateException.create(
                    data.getTree(), data.getPlannedDate());
        }

        pruningRepository.create(domainMapper.toEntity(data));

        return null;
    }
}