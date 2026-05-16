package co.edu.uco.treepruning.features.status.getstatus.application.usecase;

import java.util.List;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.status.getstatus.application.usecase.domain.GetStatusDomain;

public interface GetStatusUseCase extends UseCase<Void, List<GetStatusDomain>> {
}
