package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.FamilyJPAEntity;

public interface FamilyJPARepository extends JpaRepository<FamilyJPAEntity, UUID> {

    @Query("SELECT f FROM FamilyJPAEntity f WHERE " +
           "(cast(:id as String) = '00000000-0000-0000-0000-000000000000' OR f.id = :id) AND " +
           "('' = :commonName OR f.commonName ILIKE concat('%', cast(:commonName as String), '%')) AND " +
           "('' = :scientificName OR f.scientificName ILIKE concat('%', cast(:scientificName as String), '%'))")
    List<FamilyJPAEntity> findByFilter(@Param("id") UUID id,
                                       @Param("commonName") String commonName,
                                       @Param("scientificName") String scientificName);
}
