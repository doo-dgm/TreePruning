package co.edu.uco.treepruning.features.pruning.gettype.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.pruning.gettype.application.usecase.domain.GetTypeDomain;

public interface GetTypeUseCase extends UseCase<Void, List<GetTypeDomain>> {
}
