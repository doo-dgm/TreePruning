package co.edu.uco.treepruning.features.status.getstatus.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.features.status.getstatus.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.StatusEntity;

@Mapper(componentModel = "spring")
public interface GetStatusDomainMapper {
	GetStatusDomain toDomain(StatusEntity entity);
}
