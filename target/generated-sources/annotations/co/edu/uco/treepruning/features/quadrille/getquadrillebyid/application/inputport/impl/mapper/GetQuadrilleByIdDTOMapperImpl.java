package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.impl.mapper;

import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.inputport.dto.GetQuadrilleByIdDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase.domain.GetQuadrilleByIdDomain;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-16T12:28:51-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.1 (Oracle Corporation)"
)
@Component
public class GetQuadrilleByIdDTOMapperImpl implements GetQuadrilleByIdDTOMapper {

    @Override
    public GetQuadrilleByIdDTO toDTO(GetQuadrilleByIdDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String quadrilleName = null;
        UUID manager = null;

        id = domain.getId();
        quadrilleName = domain.getQuadrilleName();
        manager = domain.getManager();

        GetQuadrilleByIdDTO getQuadrilleByIdDTO = new GetQuadrilleByIdDTO( id, quadrilleName, manager );

        return getQuadrilleByIdDTO;
    }
}
