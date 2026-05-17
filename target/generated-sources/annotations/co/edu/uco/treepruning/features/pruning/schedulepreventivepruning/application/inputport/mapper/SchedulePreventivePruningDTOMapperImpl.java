package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.mapper;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class SchedulePreventivePruningDTOMapperImpl implements SchedulePreventivePruningDTOMapper {

    @Override
    public SchedulePreventivePruningDomain toDomain(SchedulePreventivePruningDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID status = null;
        LocalDate plannedDate = null;
        LocalDate executedDate = null;
        UUID tree = null;
        UUID quadrille = null;
        UUID type = null;
        String photographicRecordPath = null;
        String observations = null;

        status = dto.getStatus();
        plannedDate = dto.getPlannedDate();
        executedDate = dto.getExecutedDate();
        tree = dto.getTree();
        quadrille = dto.getQuadrille();
        type = dto.getType();
        photographicRecordPath = dto.getPhotographicRecordPath();
        observations = dto.getObservations();

        SchedulePreventivePruningDomain schedulePreventivePruningDomain = new SchedulePreventivePruningDomain( status, plannedDate, executedDate, tree, quadrille, type, photographicRecordPath, observations );

        return schedulePreventivePruningDomain;
    }
}
