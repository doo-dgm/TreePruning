package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.SectorJPAEntity;

public interface SectorJPARepository extends JpaRepository<SectorJPAEntity, UUID> {

    @Query("SELECT s FROM SectorJPAEntity s WHERE " +
           "(cast(:id as String) = '00000000-0000-0000-0000-000000000000' OR s.id = :id) AND " +
           "('' = :name OR s.name ILIKE concat('%', cast(:name as String), '%'))")
    List<SectorJPAEntity> findByFilter(@Param("id") UUID id,
                                       @Param("name") String name);
}
