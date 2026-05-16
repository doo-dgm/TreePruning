package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Mapper(componentModel = "spring")
public interface SchedulePreventivePruningDomainMapper {

    @Mapping(source = "domain.id",                   target = "id")
    @Mapping(source = "status",                      target = "status")
    @Mapping(source = "domain.plannedDate",          target = "plannedDate")
    @Mapping(source = "domain.executedDate",         target = "executedDate")
    @Mapping(source = "tree",                        target = "tree")
    @Mapping(source = "quadrille",                   target = "quadrille")
    @Mapping(source = "type",                        target = "type")
    @Mapping(target = "pqr",                         ignore = true)
    @Mapping(source = "domain.photographicRecordPath", target = "photographicRecordPath")
    @Mapping(source = "domain.observations",         target = "observations")
    PruningEntity toEntity(
            SchedulePreventivePruningDomain domain,
            StatusEntity status,
            TreeEntity tree,
            QuadrilleEntity quadrille,
            TypeEntity type);
}
