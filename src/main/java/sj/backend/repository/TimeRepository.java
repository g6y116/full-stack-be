package sj.backend.repository;

import org.springframework.data.repository.CrudRepository;
import sj.backend.entity.TimeEntity;

public interface TimeRepository extends CrudRepository<TimeEntity, Long> {
}