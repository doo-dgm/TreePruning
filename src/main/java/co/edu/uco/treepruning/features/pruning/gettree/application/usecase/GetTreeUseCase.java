package co.edu.uco.treepruning.features.pruning.gettree.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.pruning.gettree.application.usecase.domain.GetTreeDomain;

public interface GetTreeUseCase extends UseCase<Void, List<GetTreeDomain>> {
}
