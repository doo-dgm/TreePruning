package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.QuadrilleJPAEntity;

public interface QuadrilleJPARepository extends JpaRepository<QuadrilleJPAEntity, UUID> {

    @Query("SELECT q FROM QuadrilleJPAEntity q WHERE " +
           "(cast(:id as String) = '00000000-0000-0000-0000-000000000000' OR q.id = :id) AND " +
           "('' = :quadrilleName OR q.quadrilleName ILIKE concat('%', cast(:quadrilleName as String), '%')) AND " +
           "(cast(:managerId as String) = '00000000-0000-0000-0000-000000000000' OR q.manager.id = :managerId)")
    List<QuadrilleJPAEntity> findByFilter(@Param("id") UUID id,
                                          @Param("quadrilleName") String quadrilleName,
                                          @Param("managerId") UUID managerId);
}
