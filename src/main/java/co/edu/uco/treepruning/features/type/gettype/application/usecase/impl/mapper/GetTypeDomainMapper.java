package co.edu.uco.treepruning.features.type.gettype.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.type.gettype.application.usecase.domain.GetTypeDomain;
import co.edu.uco.treepruning.infrastructure.persistence
        .repository.entity.TypeEntity;

@Mapper(componentModel = "spring")
public interface GetTypeDomainMapper {
    GetTypeDomain toDomain(TypeEntity entity);
}