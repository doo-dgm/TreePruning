package co.edu.uco.treepruning.features.quadrille.getquadrillebyid.application.usecase;

import java.util.UUID;
import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.QuadrilleEntity;

public interface GetQuadrilleByIdUseCase extends UseCase<UUID, QuadrilleEntity> {
}