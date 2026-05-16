package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.impl.mapper;

import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.domain.GetQuadrilleByIdDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T12:28:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class GetQuadrilleByIdDomainMapperImpl implements GetQuadrilleByIdDomainMapper {

    @Override
    public GetQuadrilleByIdDomain toDomain(QuadrilleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID manager = null;
        UUID id = null;
        String quadrilleName = null;

        manager = entityManagerId( entity );
        id = entity.getId();
        quadrilleName = entity.getQuadrilleName();

        GetQuadrilleByIdDomain getQuadrilleByIdDomain = new GetQuadrilleByIdDomain( id, quadrilleName, manager );

        return getQuadrilleByIdDomain;
    }

    private UUID entityManagerId(QuadrilleEntity quadrilleEntity) {
        if ( quadrilleEntity == null ) {
            return null;
        }
        ManagerEntity manager = quadrilleEntity.getManager();
        if ( manager == null ) {
            return null;
        }
        UUID id = manager.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
