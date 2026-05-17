package co.edu.uco.treepruning.features.type.gettype.application.inputport.impl.mapper;

import co.edu.uco.treepruning.features.type.gettype.application.inputport.dto.GetTypeDTO;
import co.edu.uco.treepruning.features.type.gettype.application.usecase.domain.GetTypeDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T19:01:12-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260421-0704, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class GetTypeDTOMapperImpl implements GetTypeDTOMapper {

    @Override
    public GetTypeDTO toDTO(GetTypeDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = domain.getId();
        name = domain.getName();

        GetTypeDTO getTypeDTO = new GetTypeDTO( id, name );

        return getTypeDTO;
    }

    @Override
    public List<GetTypeDTO> toDTOList(List<GetTypeDomain> domains) {
        if ( domains == null ) {
            return null;
        }

        List<GetTypeDTO> list = new ArrayList<GetTypeDTO>( domains.size() );
        for ( GetTypeDomain getTypeDomain : domains ) {
            list.add( toDTO( getTypeDomain ) );
        }

        return list;
    }
}
