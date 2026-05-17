package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator.SchedulePreventivePruningDTOValidator;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.mapper.SchedulePreventivePruningDTOMapper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

@Service
@Transactional(rollbackFor = Exception.class)
public class SchedulePreventivePruningInteractor implements SchedulePreventivePruningInputPort {

    private final SchedulePreventivePruningUseCase useCase;
    private SchedulePreventivePruningDTOMapper mapper;

    public SchedulePreventivePruningInteractor(
            SchedulePreventivePruningUseCase useCase, SchedulePreventivePruningDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public Void execute(SchedulePreventivePruningDTO data) {
    	
    	SchedulePreventivePruningDomain domain = mapper.toDomain(data);
    	
        SchedulePreventivePruningDTOValidator.validateStatus(domain.getStatus());
        SchedulePreventivePruningDTOValidator.validatePlannedDate(domain.getPlannedDate());
        SchedulePreventivePruningDTOValidator.validateExecutedDate(domain.getExecutedDate(),domain.getPlannedDate());
        SchedulePreventivePruningDTOValidator.validateTree(domain.getTree());
        SchedulePreventivePruningDTOValidator.validateQuadrille(domain.getQuadrille());
        SchedulePreventivePruningDTOValidator.validateType(domain.getType());
        SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath( domain.getPhotographicRecordPath());
        SchedulePreventivePruningDTOValidator.validateObservations(domain.getObservations());

        return useCase.execute(domain);
    }
}