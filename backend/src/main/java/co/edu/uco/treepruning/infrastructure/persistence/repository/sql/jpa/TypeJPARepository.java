package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.TypeJPAEntity;

public interface TypeJPARepository extends JpaRepository<TypeJPAEntity, UUID> {

    @Query("SELECT t FROM TypeJPAEntity t WHERE " +
           "(cast(:id as String) = '00000000-0000-0000-0000-000000000000' OR t.id = :id) AND " +
           "('' = :name OR t.name ILIKE concat('%', cast(:name as String), '%'))")
    List<TypeJPAEntity> findByFilter(@Param("id") UUID id,
                                     @Param("name") String name);
}
