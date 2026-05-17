package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.CountryEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.CountryJPAEntity;
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
public class CountryEntityMapperImpl implements CountryEntityMapper {

    @Override
    public CountryJPAEntity toJPA(CountryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        CountryJPAEntity countryJPAEntity = new CountryJPAEntity( id, name );

        return countryJPAEntity;
    }

    @Override
    public CountryEntity toEntity(CountryJPAEntity jpaEntity) {
        if ( jpaEntity == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setId( jpaEntity.getId() );
        countryEntity.setName( jpaEntity.getName() );

        return countryEntity;
    }

    @Override
    public List<CountryEntity> toEntityList(List<CountryJPAEntity> jpaEntities) {
        if ( jpaEntities == null ) {
            return null;
        }

        List<CountryEntity> list = new ArrayList<CountryEntity>( jpaEntities.size() );
        for ( CountryJPAEntity countryJPAEntity : jpaEntities ) {
            list.add( toEntity( countryJPAEntity ) );
        }

        return list;
    }
}
