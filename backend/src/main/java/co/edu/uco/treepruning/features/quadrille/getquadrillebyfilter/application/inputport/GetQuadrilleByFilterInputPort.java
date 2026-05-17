package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleFilterDTO;

public interface GetQuadrilleByFilterInputPort extends InputPort<GetQuadrilleFilterDTO, List<GetQuadrilleDTO>> {
}
