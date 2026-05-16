package co.edu.uco.treepruning.features.pruning.gettree.application.inputport;

import java.util.List;
import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.pruning.gettree.application.inputport.dto.GetTreeDTO;

public interface GetTreeInputPort extends InputPort<Void, List<GetTreeDTO>> {
}
