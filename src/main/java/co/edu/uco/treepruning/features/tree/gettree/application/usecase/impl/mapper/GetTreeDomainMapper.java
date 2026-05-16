package co.edu.uco.treepruning.features.tree.gettree.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.features.tree.gettree.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.TreeEntity;

@Mapper(componentModel = "spring")
public interface GetTreeDomainMapper {

    @Mapping(source = "family.id", target = "family")
    @Mapping(source = "sector.id", target = "sector")
    @Mapping(source = "programming.id", target = "programming")
    GetTreeDomain toDomain(TreeEntity entity);
}
