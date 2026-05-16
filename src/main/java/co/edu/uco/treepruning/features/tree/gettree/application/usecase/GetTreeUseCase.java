package co.edu.uco.treepruning.features.tree.gettree.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.tree.gettree.application.usecase.domain.GetTreeDomain;

public interface GetTreeUseCase extends UseCase<Void, List<GetTreeDomain>> {
}
