package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.mapper;

import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T12:28:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class SchedulePreventivePruningDomainMapperImpl implements SchedulePreventivePruningDomainMapper {

    @Override
    public PruningEntity toEntity(SchedulePreventivePruningDomain domain) {
        if ( domain == null ) {
            return null;
        }

        PruningEntity pruningEntity = new PruningEntity();

        pruningEntity.setStatus( schedulePreventivePruningDomainToStatusEntity( domain ) );
        pruningEntity.setTree( schedulePreventivePruningDomainToTreeEntity( domain ) );
        pruningEntity.setQuadrille( schedulePreventivePruningDomainToQuadrilleEntity( domain ) );
        pruningEntity.setType( schedulePreventivePruningDomainToTypeEntity( domain ) );
        pruningEntity.setId( domain.getId() );
        pruningEntity.setPlannedDate( domain.getPlannedDate() );
        pruningEntity.setExecutedDate( domain.getExecutedDate() );
        pruningEntity.setPhotographicRecordPath( domain.getPhotographicRecordPath() );
        pruningEntity.setObservations( domain.getObservations() );

        return pruningEntity;
    }

    protected StatusEntity schedulePreventivePruningDomainToStatusEntity(SchedulePreventivePruningDomain schedulePreventivePruningDomain) {
        if ( schedulePreventivePruningDomain == null ) {
            return null;
        }

        StatusEntity statusEntity = new StatusEntity();

        statusEntity.setId( schedulePreventivePruningDomain.getStatus() );

        return statusEntity;
    }

    protected TreeEntity schedulePreventivePruningDomainToTreeEntity(SchedulePreventivePruningDomain schedulePreventivePruningDomain) {
        if ( schedulePreventivePruningDomain == null ) {
            return null;
        }

        TreeEntity treeEntity = new TreeEntity();

        treeEntity.setId( schedulePreventivePruningDomain.getTree() );

        return treeEntity;
    }

    protected QuadrilleEntity schedulePreventivePruningDomainToQuadrilleEntity(SchedulePreventivePruningDomain schedulePreventivePruningDomain) {
        if ( schedulePreventivePruningDomain == null ) {
            return null;
        }

        QuadrilleEntity quadrilleEntity = new QuadrilleEntity();

        quadrilleEntity.setId( schedulePreventivePruningDomain.getQuadrille() );

        return quadrilleEntity;
    }

    protected TypeEntity schedulePreventivePruningDomainToTypeEntity(SchedulePreventivePruningDomain schedulePreventivePruningDomain) {
        if ( schedulePreventivePruningDomain == null ) {
            return null;
        }

        TypeEntity typeEntity = new TypeEntity();

        typeEntity.setId( schedulePreventivePruningDomain.getType() );

        return typeEntity;
    }
}
