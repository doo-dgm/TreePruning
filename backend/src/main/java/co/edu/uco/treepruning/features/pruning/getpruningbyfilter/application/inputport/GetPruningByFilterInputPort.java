package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningFilterDTO;

public interface GetPruningByFilterInputPort extends InputPort<GetPruningFilterDTO, List<GetPruningDTO>> {
}
