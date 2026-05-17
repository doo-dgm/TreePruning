package co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.treepruning.infrastructure.persistence.repository.PruningRepository;
import co.edu.uco.treepruning.infrastructure.persistence.repository.adapter.sql.jpa.mapper.PruningEntityMapper;
import co.edu.uco.treepruning.infrastructure.persistence.repository.entity.PruningEntity;
import co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PruningJPARepository;

@Repository
public class PruningJPARepositoryAdapter implements PruningRepository {

    private final PruningJPARepository repository;
    private final PruningEntityMapper mapper;

    public PruningJPARepositoryAdapter(PruningJPARepository repository,
            PruningEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(final PruningEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(final UUID id, final PruningEntity entity) {
        // TODO
    }

    @Override
    public void delete(final UUID id) {
        repository.deleteById(id);
    }

    @Override
    public PruningEntity findById(final UUID id) {
        return repository.findById(id)
                .map(mapper::toEntity)
                .orElse(null);
    }

    @Override
    public List<PruningEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public List<PruningEntity> findByFilter(final PruningEntity filter) {
        // TODO
        return List.of();
    }

    @Override
    public boolean existsByTreeAndPlannedDate(final UUID treeId, final LocalDate plannedDate) {
        return repository.existsByTree_IdAndPlannedDate(treeId, plannedDate);
    }
}
