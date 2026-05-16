package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator.SchedulePreventivePruningDTOValidator;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.SchedulePreventivePruningUseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

@Service
@Transactional(rollbackFor = Exception.class)
public class SchedulePreventivePruningInteractor implements SchedulePreventivePruningInputPort {

    private final SchedulePreventivePruningUseCase useCase;

    public SchedulePreventivePruningInteractor(
            SchedulePreventivePruningUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(SchedulePreventivePruningDTO data) {
        SchedulePreventivePruningDTOValidator.validateStatus(data.getStatus());
        SchedulePreventivePruningDTOValidator.validatePlannedDate(data.getPlannedDate());
        SchedulePreventivePruningDTOValidator.validateExecutedDate(data.getExecutedDate(),data.getPlannedDate());
        SchedulePreventivePruningDTOValidator.validateTree(data.getTree());
        SchedulePreventivePruningDTOValidator.validateQuadrille(data.getQuadrille());
        SchedulePreventivePruningDTOValidator.validateType(data.getType());
        SchedulePreventivePruningDTOValidator.validatePhotographicRecordPath( data.getPhotographicRecordPath());
        SchedulePreventivePruningDTOValidator.validateObservations(data.getObservations());

        return useCase.execute(new SchedulePreventivePruningDomain(
                data.getStatus(),
                data.getPlannedDate(),
                data.getExecutedDate(),
                data.getTree(),
                data.getQuadrille(),
                data.getType(),
                data.getPhotographicRecordPath(),
                data.getObservations()
        ));
    }
}