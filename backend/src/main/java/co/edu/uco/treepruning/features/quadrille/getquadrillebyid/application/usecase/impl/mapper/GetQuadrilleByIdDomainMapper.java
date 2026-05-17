package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.domain.GetQuadrilleByIdDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

@Mapper(componentModel = "spring")
public interface GetQuadrilleByIdDomainMapper {

    @Mapping(source = "manager.id", target = "manager")
    GetQuadrilleByIdDomain toDomain(QuadrilleEntity entity);
}
