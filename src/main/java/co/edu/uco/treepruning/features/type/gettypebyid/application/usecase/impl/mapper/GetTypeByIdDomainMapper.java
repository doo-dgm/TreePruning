package co.edu.uco.treepruning.features.type.gettypebyid.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.type.gettypebyid.application.usecase.domain.GetTypeByIdDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TypeEntity;

@Mapper(componentModel = "spring")
public interface GetTypeByIdDomainMapper {
    GetTypeByIdDomain toDomain(TypeEntity entity);
}
