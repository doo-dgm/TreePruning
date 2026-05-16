package co.edu.uco.treepruning.features.status.getstatus.application.usecase.impl.mapper;

import co.edu.uco.treepruning.features.status.getstatus.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T12:28:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class GetStatusDomainMapperImpl implements GetStatusDomainMapper {

    @Override
    public GetStatusDomain toDomain(StatusEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = entity.getId();
        name = entity.getName();

        GetStatusDomain getStatusDomain = new GetStatusDomain( id, name );

        return getStatusDomain;
    }
}
