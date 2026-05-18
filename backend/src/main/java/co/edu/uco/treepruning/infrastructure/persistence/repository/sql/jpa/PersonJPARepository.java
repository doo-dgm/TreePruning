package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity.PersonJPAEntity;

public interface PersonJPARepository extends JpaRepository<PersonJPAEntity, UUID> {

    @Query("SELECT p FROM PersonJPAEntity p WHERE " +
           "(cast(:id as String) = '00000000-0000-0000-0000-000000000000' OR p.id = :id) AND " +
           "('' = :firstName OR p.firstName ILIKE concat('%', cast(:firstName as String), '%')) AND " +
           "('' = :firstLastName OR p.firstLastName ILIKE concat('%', cast(:firstLastName as String), '%'))")
    List<PersonJPAEntity> findByFilter(@Param("id") UUID id,
                                       @Param("firstName") String firstName,
                                       @Param("firstLastName") String firstLastName);
}
