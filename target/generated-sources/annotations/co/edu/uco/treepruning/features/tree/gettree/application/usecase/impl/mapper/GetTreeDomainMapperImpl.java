package co.edu.uco.treepruning.features.tree.gettree.application.usecase.impl.mapper;

import co.edu.uco.treepruning.features.tree.gettree.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.FamilyEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ProgrammingEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class GetTreeDomainMapperImpl implements GetTreeDomainMapper {

    @Override
    public GetTreeDomain toDomain(TreeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID family = null;
        UUID sector = null;
        UUID programming = null;
        UUID id = null;
        String longitude = null;
        String latitude = null;

        family = entityFamilyId( entity );
        sector = entitySectorId( entity );
        programming = entityProgrammingId( entity );
        id = entity.getId();
        longitude = entity.getLongitude();
        latitude = entity.getLatitude();

        GetTreeDomain getTreeDomain = new GetTreeDomain( id, longitude, latitude, family, sector, programming );

        return getTreeDomain;
    }

    private UUID entityFamilyId(TreeEntity treeEntity) {
        if ( treeEntity == null ) {
            return null;
        }
        FamilyEntity family = treeEntity.getFamily();
        if ( family == null ) {
            return null;
        }
        UUID id = family.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private UUID entitySectorId(TreeEntity treeEntity) {
        if ( treeEntity == null ) {
            return null;
        }
        SectorEntity sector = treeEntity.getSector();
        if ( sector == null ) {
            return null;
        }
        UUID id = sector.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private UUID entityProgrammingId(TreeEntity treeEntity) {
        if ( treeEntity == null ) {
            return null;
        }
        ProgrammingEntity programming = treeEntity.getProgramming();
        if ( programming == null ) {
            return null;
        }
        UUID id = programming.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
