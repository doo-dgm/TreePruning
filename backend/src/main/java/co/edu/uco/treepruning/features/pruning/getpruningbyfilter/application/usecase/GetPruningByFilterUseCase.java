package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningFilterDTO;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain.GetPruningDomain;

public interface GetPruningByFilterUseCase extends UseCase<GetPruningFilterDTO, List<GetPruningDomain>> {
}
