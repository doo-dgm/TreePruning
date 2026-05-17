package co.edu.uco.treepruning.features.tree.gettreebyid.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.usecase.domain.GetTreeByIdDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;

@Mapper(componentModel = "spring")
public interface GetTreeByIdDomainMapper {

    @Mapping(source = "family.id", target = "family")
    @Mapping(source = "sector.id", target = "sector")
    @Mapping(source = "programming.id", target = "programming")
    GetTreeByIdDomain toDomain(TreeEntity entity);
}
