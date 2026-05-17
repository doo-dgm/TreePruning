package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.SectorEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.MunicipalityJPAEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.SectorJPAEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class SectorEntityMapperImpl implements SectorEntityMapper {

    @Autowired
    private MunicipalityEntityMapper municipalityEntityMapper;

    @Override
    public SectorJPAEntity toJPA(SectorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        MunicipalityJPAEntity municipality = null;

        id = entity.getId();
        name = entity.getName();
        municipality = municipalityEntityMapper.toJPA( entity.getMunicipality() );

        SectorJPAEntity sectorJPAEntity = new SectorJPAEntity( id, name, municipality );

        return sectorJPAEntity;
    }

    @Override
    public SectorEntity toEntity(SectorJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        SectorEntity sectorEntity = new SectorEntity();

        sectorEntity.setId( jpaEntity.getId() );
        sectorEntity.setName( jpaEntity.getName() );
        sectorEntity.setMunicipality( municipalityEntityMapper.toEntity( jpaEntity.getMunicipality() ) );

        return sectorEntity;
    }

    @Override
    public List<SectorEntity> toEntityList(List<SectorJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<SectorEntity> list = new ArrayList<SectorEntity>( jpaEntities.size() );
        for ( SectorJPAEntity sectorJPAEntity : jpaEntities ) {
            list.add( toEntity( sectorJPAEntity ) );
        }

        return list;
    }
}
