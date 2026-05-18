package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PruningJPAEntity;

public interface PruningJPARepository extends JpaRepository<PruningJPAEntity, UUID> {

    boolean existsByTree_IdAndPlannedDate(UUID treeId, LocalDate plannedDate);

    @Query("SELECT p FROM PruningJPAEntity p WHERE " +
           "(cast(:id as String) = '00000000-0000-0000-0000-000000000000' OR p.id = :id) AND " +
           "(cast(:statusId as String) = '00000000-0000-0000-0000-000000000000' OR p.status.id = :statusId) AND " +
           "(cast(:treeId as String) = '00000000-0000-0000-0000-000000000000' OR p.tree.id = :treeId) AND " +
           "(cast(:quadrilleId as String) = '00000000-0000-0000-0000-000000000000' OR p.quadrille.id = :quadrilleId) AND " +
           "(cast(:typeId as String) = '00000000-0000-0000-0000-000000000000' OR p.type.id = :typeId) AND " +
           "(:plannedDate IS NULL OR p.plannedDate = :plannedDate)")
    List<PruningJPAEntity> findByFilter(@Param("id") UUID id,
                                        @Param("statusId") UUID statusId,
                                        @Param("treeId") UUID treeId,
                                        @Param("quadrilleId") UUID quadrilleId,
                                        @Param("typeId") UUID typeId,
                                        @Param("plannedDate") LocalDate plannedDate);
}
