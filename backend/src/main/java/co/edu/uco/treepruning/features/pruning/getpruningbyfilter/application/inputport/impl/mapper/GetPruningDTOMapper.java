package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.impl.mapper;

import org.mapstruct.Mapper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;

@Mapper(componentModel = "spring")
public interface GetPruningDTOMapper {

    GetPruningDTO toDTO(GetPruningDomain domain);

    default GetStatusDTO toStatusDTO(GetStatusDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetStatusDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetStatusDTO(d.getId(), d.getName());
    }

    default GetTreeDTO toTreeDTO(GetTreeDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetTreeDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(), TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault(), TextHelper.getDefault(), TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault(), TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault());
        }
        return new GetTreeDTO(d.getId(), d.getLongitude(), d.getLatitude(),
                d.getFamily(), d.getFamilyCommonName(), d.getFamilyScientificName(),
                d.getSector(), d.getSectorName(), d.getProgramming());
    }

    default GetQuadrilleDTO toQuadrilleDTO(GetQuadrilleDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetQuadrilleDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault(),
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetQuadrilleDTO(d.getId(), d.getQuadrilleName(),
                d.getManager(), d.getManagerName());
    }

    default GetTypeDTO toTypeDTO(GetTypeDomain d) {
        if (ObjectHelper.isNull(d)) {
            return new GetTypeDTO(
                    UUIDHelper.getUUIDHelper().getDefault(),
                    TextHelper.getDefault());
        }
        return new GetTypeDTO(d.getId(), d.getName());
    }
}
