package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.ManagerEntity;

@Mapper(componentModel = "spring")
public interface GetQuadrilleDomainMapper {

    @Mapping(source = "manager.id", target = "manager")
    @Mapping(target = "managerName", expression = "java(buildManagerName(entity.getManager()))")
    GetQuadrilleDomain toDomain(QuadrilleEntity entity);

    default String buildManagerName(ManagerEntity manager) {
        if (ObjectHelper.isNull(manager) || ObjectHelper.isNull(manager.getPerson())) {
            return TextHelper.getDefault();
        }
        return TextHelper.getDefaultWithTrim(
                TextHelper.getDefault(manager.getPerson().getFirstName()) + " " +
                TextHelper.getDefault(manager.getPerson().getFirstLastName()));
    }
}
