package co.edu.uco.treepruning.features.type.gettype.application.usecase.impl.mapper;

import co.edu.uco.treepruning.features.type.gettype.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class GetTypeDomainMapperImpl implements GetTypeDomainMapper {

    @Override
    public GetTypeDomain toDomain(TypeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        GetTypeDomain getTypeDomain = new GetTypeDomain( id, name );

        return getTypeDomain;
    }
}
