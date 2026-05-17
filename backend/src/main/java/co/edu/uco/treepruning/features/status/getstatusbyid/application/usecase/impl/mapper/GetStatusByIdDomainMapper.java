package co.edu.uco.treepruning.features.status.getstatusbyid.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.status.getstatusbyid.application.usecase.domain.GetStatusByIdDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;

@Mapper(componentModel = "spring")
public interface GetStatusByIdDomainMapper {
    GetStatusByIdDomain toDomain(StatusEntity entity);
}
