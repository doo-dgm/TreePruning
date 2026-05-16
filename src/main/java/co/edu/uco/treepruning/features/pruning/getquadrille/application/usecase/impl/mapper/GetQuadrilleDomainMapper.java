package co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.features.pruning.getquadrille.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

@Mapper(componentModel = "spring")
public interface GetQuadrilleDomainMapper {

    @Mapping(source = "manager.id", target = "manager")
    GetQuadrilleDomain toDomain(QuadrilleEntity entity);
}
