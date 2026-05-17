package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.StatusJPAEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class StatusEntityMapperImpl implements StatusEntityMapper {

    @Override
    public StatusJPAEntity toJPA(StatusEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        StatusJPAEntity statusJPAEntity = new StatusJPAEntity( id, name );

        return statusJPAEntity;
    }

    @Override
    public StatusEntity toEntity(StatusJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        StatusEntity statusEntity = new StatusEntity();

        statusEntity.setId( jpaEntity.getId() );
        statusEntity.setName( jpaEntity.getName() );

        return statusEntity;
    }

    @Override
    public List<StatusEntity> toEntityList(List<StatusJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<StatusEntity> list = new ArrayList<StatusEntity>( jpaEntities.size() );
        for ( StatusJPAEntity statusJPAEntity : jpaEntities ) {
            list.add( toEntity( statusJPAEntity ) );
        }

        return list;
    }
}
