package co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.impl.mapper;

import co.edu.uco.treepruning.features.tree.gettreebyid.application.inputport.dto.GetTreeByIdDTO;
import co.edu.uco.treepruning.features.tree.gettreebyid.application.usecase.domain.GetTreeByIdDomain;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:13-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class GetTreeByIdDTOMapperImpl implements GetTreeByIdDTOMapper {

    @Override
    public GetTreeByIdDTO toDTO(GetTreeByIdDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String longitude = null;
        String latitude = null;
        UUID family = null;
        UUID sector = null;
        UUID programming = null;

        id = domain.getId();
        longitude = domain.getLongitude();
        latitude = domain.getLatitude();
        family = domain.getFamily();
        sector = domain.getSector();
        programming = domain.getProgramming();

        GetTreeByIdDTO getTreeByIdDTO = new GetTreeByIdDTO( id, longitude, latitude, family, sector, programming );

        return getTreeByIdDTO;
    }
}
