package co.edu.uco.treepruning.infrastructure.persistence.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;

public interface PruningRepository {

    void create(PruningEntity entity);

    void update(UUID id, PruningEntity entity);

    void delete(UUID id);

    List<PruningEntity> findByFilter(UUID id, UUID statusId, UUID treeId, UUID quadrilleId, UUID typeId, LocalDate plannedDate);

    boolean existsByTreeAndPlannedDate(UUID treeId, LocalDate plannedDate);
}